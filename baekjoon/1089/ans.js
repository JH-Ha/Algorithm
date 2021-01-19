/** @format */

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    //console.log(input);
    solve();
    process.exit();
});


function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let numArr = [
        "###...#.###.###.#.#.###.###.###.###.###",
        "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
        "#.#...#.###.###.###.###.###...#.###.###",
        "#.#...#.#.....#...#...#.#.#...#.#.#...#",
        "###...#.###.###...#.###.###...#.###.###"
    ];
    let possible = [];
    let map = [];
    for (let i = 0; i < 5; i++) {
        map.push(input.shift());
    }
    for (let i = 0; i < n; i++) {
        let startIdx = 4 * i;
        let row = [];
        for (let t = 0; t < 10; t++) {
            let numStartIdx = 4 * t;
            let isPossible = true;
            for (let x = 0; x < 5; x++) {
                for (let y = numStartIdx; y < numStartIdx + 3; y++) {
                    if (map[x][startIdx + y - numStartIdx] == "#" && numArr[x][y] == ".") {
                        isPossible = false;
                        break;
                    }
                }
                if (!isPossible) break;
            }
            if (isPossible) {
                row.push(t);
            }
        }
        possible.push(row);
    }
    let totalCase = 1;
    let totalSum = 0;
    for (let i = 0; i < possible.length; i++) {
        totalCase *= (possible[i].length);
    }
    for (let i = 0; i < possible.length; i++) {
        let mul = Math.pow(10, possible.length - 1 - i);
        for (let j = 0; j < possible[i].length; j++) {
            totalSum += mul * possible[i][j] * totalCase / possible[i].length;
        }
    }

    //console.log(possible);
    if (totalCase == 0) {
        console.log(-1);
    } else {
        console.log(totalSum / totalCase);
    }
}
