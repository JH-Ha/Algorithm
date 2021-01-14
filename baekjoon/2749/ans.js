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
    let n = BigInt(line);

    let mod = 1000000;
    let fibo = [];
    fibo.push(0);
    fibo.push(1);
    for (let i = 2; i < 1500000; i++) {
        fibo.push((fibo[i - 1] + fibo[i - 2]) % mod);
    }
    console.log(fibo[n % BigInt(1500000)]);

}
