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
    constructor(id, time) {
        this.time = time;
        this.endTime = time;
        this.id = id;
        this.numParent = 0;
        this.children = [];
    }
}

function solve() {

    let lineIdx = 0;
    let line = input[lineIdx++];
    let spt = line.split(" ").map(x => parseInt(x));
    let t = spt[0];
    while (t-- > 0) {
        line = input[lineIdx++];
        spt = line.split(" ").map(x => parseInt(x));
        let n = spt[0];
        let k = spt[1];
        let buildingArr = [new Building(0, 0)];

        let time = input[lineIdx++].split(" ").map(x => parseInt(x));

        for (let i = 1; i <= n; i++) {
            buildingArr.push(new Building(i, time[i - 1]));
        }

        for (let i = 0; i < k; i++) {
            spt = input[lineIdx++].split(" ").map(x => parseInt(x));
            let a = spt[0];
            let b = spt[1];
            buildingArr[a].children.push(b);
            buildingArr[b].numParent++;
        }
        let q = [];
        for (let i = 1; i <= n; i++) {
            if (buildingArr[i].numParent == 0) {
                //pq.insert(buildingArr[i]);
                q.push(buildingArr[i]);
            }
        }
        let w = parseInt(input[lineIdx++]);
        while (q.length != 0) {
            //let top = pq.removeMin();
            let top = q.shift();

            if (top.id == w) {
                break;
            }
            for (let i = 0; i < top.children.length; i++) {
                let child = buildingArr[top.children[i]];
                child.numParent--;
                if (child.numParent == 0) {
                    //pq.insert(child);
                    q.push(child);
                }
                if (child.endTime < top.endTime + child.time)
                    child.endTime = top.endTime + child.time;
            }
        }
        console.log(buildingArr[w].endTime);

    }
}
