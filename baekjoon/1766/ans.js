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
class Problem {
    constructor(id) {
        this.parentCnt = 0;
        this.id = id;
        this.children = [];
    }
    addChild(problemArr, child) {
        this.children.push(child);
        problemArr[child].parentCnt++;
    }
}
class PriorityQueue {
    constructor(comp) {
        this.queue = [];
        if (comp == undefined) {
            this.comp = (a, b) => {
                return a - b;
            }
        } else {
            this.comp = comp;
        }
    }
    insert(ele) {
        for (let i = 0; i < this.queue.length; i++) {
            if (this.comp(ele, this.queue[i]) > 0) {
                this.queue.splice(i, 0, ele);
                return;
            }
        }
        this.queue.push(ele);
    }
    removeMin() {
        return this.queue.pop();
    }
    isEmpty() {
        return this.queue.length == 0;
    }
}

function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let m = spt[1];
    let problemArr = [];
    for (let i = 0; i <= n; i++) {
        problemArr.push(new Problem(i));
    }
    for (let i = 0; i < m; i++) {
        line = input.shift();
        spt = line.split(" ").map(x => parseInt(x));
        let a = spt[0];
        let b = spt[1];
        problemArr[a].addChild(problemArr, b);
    }
    let comp = (a, b) => {
        if (a.parentCnt > b.parentCnt) {
            return 1;
        } else if (a.parentCnt < b.parentCnt) {
            return -1;
        } else {
            return a.id - b.id;
        }
    }
    let pq = new PriorityQueue(comp);
    for (let i = 1; i <= n; i++) {
        if (problemArr[i].parentCnt == 0) {
            pq.insert(problemArr[i]);
        }
    }
    let ans = "";
    while (!pq.isEmpty()) {
        let top = pq.removeMin();
        for (let i = 0; i < top.children.length; i++) {
            let child = top.children[i];
            problemArr[child].parentCnt--;
            if (problemArr[child].parentCnt == 0) {
                pq.insert(problemArr[child]);
            }
        }
        ans += top.id + " ";
    }
    console.log(ans.trimEnd());

}
