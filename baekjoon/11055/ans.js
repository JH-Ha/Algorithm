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

class Point {
    constructor(id, num) {
        this.id = id;
        this.num = num;
        this.prev = null;
    }
}

function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let arr = input.shift().split(" ").map(x => parseInt(x));

    let numArr = [];
    let dp = [];
    for (let i = 0; i < n; i++) {
        dp.push(-1);
    }

    let ans = 0;
    for (let i = 0; i < n; i++) {
        let num = arr[i];
        dp[i] = num;
        for (let j = 0; j < i; j++) {
            if (arr[j] < num) {
                dp[i] = Math.max(dp[j] + num, dp[i]);
            }
        }
        ans = Math.max(ans, dp[i]);
    }
    console.log(ans);

}
