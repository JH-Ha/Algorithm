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

function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let buildingArr = [null];
    for (let i = 1; i <= n; i++) {
        buildingArr.push(new Building(i));
    }
    for (let i = 1; i <= n; i++) {
        spt = input.shift().split(" ").map(x => parseInt(x));
        buildingArr[i].setTime(spt[0]);
        buildingArr[i].setEndTime(spt[0]);
        for (let j = 1; j < spt.length - 1; j++) {
            buildingArr[i].numParent++;
            buildingArr[spt[j]].children.push(i);
        }
    }
    let q = [];
    for (let i = 1; i <= n; i++) {
        if (buildingArr[i].numParent == 0) {
            q.push(buildingArr[i]);
        }
    }
    while (q.length > 0) {
        let top = q.shift();
        for (let i = 0; i < top.children.length; i++) {
            let child = buildingArr[top.children[i]];
            child.numParent--;
            if (child.numParent == 0) {
                q.push(child);
            }
            if (child.endTime < top.endTime + child.time) {
                child.endTime = top.endTime + child.time;
            }
        }
    }
    for (let i = 1; i <= n; i++) {
        console.log(buildingArr[i].endTime);
    }

}
