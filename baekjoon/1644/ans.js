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
    let n = parseInt(line);
    let check = [];
    let prime = [];
    for (let i = 0; i < n * 2; i++) {
        check.push(i);
    }
    for (let i = 2; i < n * 2; i++) {
        if (check[i] == i) {
            prime.push(i);
            for (let j = i * i; j < n * 2; j += i) {
                check[j] = i;
            }
        }
    }
    let sum = prime[0];
    let a = 0;
    let b = 0;
    let ans = 0;
    while (a <= b && b < prime.length) {
        if (sum == n) {
            ans++;
            sum -= prime[a++];
            sum += prime[++b];
        } else if (sum < n) {
            sum += prime[++b];
        } else {
            sum -= prime[a++];
        }
    }
    console.log(ans);
}
