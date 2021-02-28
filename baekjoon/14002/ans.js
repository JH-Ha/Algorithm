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
    let beforeIdx = [];
    for (let i = 0; i < n; i++) {
        beforeIdx.push(-1);
    }
    for (let i = 0; i < n; i++) {
        let num = arr[i];
        let isInsert = false;
        for (let j = 0; j < numArr.length; j++) {
            if (num <= numArr[j].num) {
                numArr[j] = new Point(i, num);
                if (j != 0)
                    beforeIdx[i] = numArr[j - 1].id;
                else
                    beforeIdx[i] = -1;
                isInsert = true;
                break;
            }
        }
        if (!isInsert) {
            if (i != 0)
                beforeIdx[i] = numArr[numArr.length - 1].id;
            else
                beforeIdx[i] = i - 1;
            numArr.push(new Point(i, num));
        }
    }
    console.log(numArr.length);
    let ans = [];
    let curId = numArr.pop().id;
    while (curId != -1) {
        ans.push(arr[curId]);
        curId = beforeIdx[curId];
    }
    console.log(ans.reverse().reduce((a, b) => a + " " + b));
}
