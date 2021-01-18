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
    let cnt = -1;
    for (let i = 0; i <= 9876543210; i++) {
        let num = i;
        let isDecreasing = true;

        while (num > 10) {
            if (num % 10 >= (Math.floor(num / 10) % 10)) {
                isDecreasing = false;
                break;
            }
            num = Math.floor(num / 10);
        }
        if (isDecreasing)
            cnt++;
        if (cnt == n) {
            console.log(i);
            break;
        }
        if (i == 999999999) {
            i = 9876543209;
        } else if (i == 99999999) {
            i = 876543209;
        } else if (i == 9999999) {
            i = 76543209;
        }
    }
    if (cnt < n) {
        console.log(-1);
    }
}
