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

function find(x, y, n, k, width) {
    if (width == 1) {
        return 0;
    }
    let smallWidth = Math.floor(width / n);
    let start = Math.floor((n - k) / 2 * smallWidth);
    if (x >= start && x < width - start &&
        y >= start && y < width - start) {
        return 1;
    }
    return find(x % smallWidth, y % smallWidth, n, k, smallWidth);
}
function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let s = spt[0];
    let n = spt[1];
    let k = spt[2];
    let r1 = spt[3];
    let r2 = spt[4];
    let c1 = spt[5];
    let c2 = spt[6];

    let ans = [];
    let width = Math.pow(n, s);

    for (let x = r1; x <= r2; x++) {
        let row = [];
        for (let y = c1; y <= c2; y++) {
            row.push(find(x, y, n, k, width));
        }
        ans.push(row);
    }
    for (let i = 0; i < ans.length; i++) {
        console.log(ans[i].reduce((a, b) => a + "" + b));
    }
}
