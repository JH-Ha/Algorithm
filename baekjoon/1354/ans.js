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

class Building {
    constructor(id) {
        this.id = id;
        this.endTime = 0;
        this.time = 0;
        this.numParent = 0;
        this.children = [];
    }
    setTime(time) {
        this.time = time;
    }
    setEndTime(endTime) {
        this.endTime = endTime;
    }
}

let map = {};

let n = null;
let p = null;
let q = null;
let x = null;
let y = null;

function find(i) {
    if (i <= 0) return 1;
    if (map[i] == undefined) {
        let a = i / p - x;
        let b = i / q - y;
        map[i] = find(a) + find(b);
    }
    return map[i];
}
function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(ele => BigInt(ele));
    n = spt[0];
    p = spt[1];
    q = spt[2];
    x = spt[3];
    y = spt[4];

    console.log(find(n));

}
