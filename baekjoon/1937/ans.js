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

function isValid(x, y, n) {
    if (x >= 0 && x < n && y >= 0 && y < n) {
        return true;
    }
    return false;
}

function dfs(x, y, n, dp, map) {
    if (dp[x][y] != -1) {
        return dp[x][y];
    }
    let dx = [0, 1, 0, -1];
    let dy = [1, 0, - 1, 0];
    let ans = 0;
    for (let i = 0; i < 4; i++) {
        let nextX = x + dx[i];
        let nextY = y + dy[i];
        if (isValid(nextX, nextY, n) && (map[nextX][nextY] > map[x][y])) {
            ans = Math.max(dfs(nextX, nextY, n, dp, map) + 1, ans);
        }
    }
    dp[x][y] = ans;
    return dp[x][y];
}

function solve() {

    let line = input.shift();
    let n = parseInt(line);
    let dp = [];
    for (let i = 0; i < n; i++) {
        let row = [];
        for (let j = 0; j < n; j++) {
            row.push(-1);
        }
        dp.push(row);
    }
    let map = [];
    for (let i = 0; i < n; i++) {
        line = input.shift().split(" ").map(x => parseInt(x));
        map.push(line);
    }
    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            ans = Math.max(dfs(i, j, n, dp, map), ans);
        }
    }
    console.log(ans + 1);

}
