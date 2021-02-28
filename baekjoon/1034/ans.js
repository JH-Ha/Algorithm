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
    let m = spt[1];
    let map = [];
    for (let i = 0; i < n; i++) {
        line = input.shift().split("").map(x => parseInt(x));
        map.push(line);
    }
    let k = parseInt(input.shift());
    let ans = 0;

    for (let i = 0; i < n; i++) {
        let numZero = 0;
        for (let j = 0; j < m; j++) {
            if (map[i][j] == 0) {
                numZero++;
            }
        }
        if (numZero <= k && ((k - numZero) % 2 == 0)) {
            let numOneRow = 0;
            for (let x = i; x < n; x++) {
                let isSame = true;
                for (let y = 0; y < m; y++) {
                    if (map[x][y] != map[i][y]) {
                        isSame = false;
                    }
                }
                if (isSame) {
                    numOneRow++;
                }
            }
            ans = Math.max(numOneRow, ans);
        }
    }
    console.log(ans);

}
