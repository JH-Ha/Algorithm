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

function addDigit(ans, end, pow) {
    while (end > 0) {
        ans[end % 10] += pow;
        end = Math.floor(end / 10);
    }
}
function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let start = 1;
    let end = n;
    let ans = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let pow = 1;
    while (start <= end) {
        while (end % 10 != 9 && end >= start) {
            addDigit(ans, end, pow);
            end--;
        }
        while (start % 10 != 0 && end >= start) {
            addDigit(ans, start, pow);
            start++;
        }
        if (start > end) break;
        start = Math.floor(start / 10);
        end = Math.floor(end / 10);
        ans = ans.map(x => x + (end - start + 1) * pow);
        pow *= 10;
    }
    console.log(ans.reduce((a, b) => a + " " + b));
}
