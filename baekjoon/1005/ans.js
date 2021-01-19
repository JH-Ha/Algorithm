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

class PriorityQueue {
    constructor(comp) {
        this.heap = [];
        this.comp = comp;
        if (comp == undefined) {
            this.comp = (a, b) => {
                return a - b;
            }
        }
    }
    removeMin() {
        if (this.isEmpty()) {
            return null;
        }
        let min = this.heap[0];
        let last = this.heap.pop();
        if (this.size() != 0) {
            this.heap[0] = last;
            this.downHeap(0);
        }
        return min;
    }
    downHeap(pos) {
        while (this.isInternal(pos)) {
            let s = null;

            //왼쪽과 오른쪽 자식중에 작은 것을 s에 넣는다.
            if (!this.hasRight(pos)) {
                s = this.left(pos);
            } else if (this.comp(this.heap[this.left(pos)], this.heap[this.right(pos)]) <= 0) {
                s = this.left(pos);
            } else {
                s = this.right(pos);
            }
            if (this.comp(this.heap[s], this.heap[pos]) < 0) {
                this.swap(pos, s);
                pos = s;
            } else {
                break;
            }
        }
    }
    upHeap(pos) {
        while (!this.isRoot(pos)) {
            let p = this.parent(pos);
            if (this.comp(this.heap[p], this.heap[pos]) <= 0) {
                break;
            }
            this.swap(p, pos);
            pos = p;
        }
    }
    swap(x, y) {
        let tmp = this.heap[x];
        this.heap[x] = this.heap[y];
        this.heap[y] = tmp;
    }
    parent(pos) {
        return parseInt((pos - 1) / 2);
    }
    left(pos) {
        return 2 * pos + 1;
    }
    right(pos) {
        return 2 * pos + 2;
    }
    size() {
        return this.heap.length;
    }
    isInternal(pos) {
        return this.hasLeft(pos);
    }
    isRoot(pos) {
        if (pos == 0) return true;
        return false;
    }
    hasLeft(pos) {
        if (this.left(pos) < this.size()) {
            return true;
        }
        return false;
    }
    hasRight(pos) {
        if (this.right(pos) < this.size()) {
            return true;
        }
        return false;
    }
    isEmpty() {
        return this.heap.length == 0;
    }
    insert(value) {
        this.heap.push(value);
        this.upHeap(this.size() - 1);
    }
    min() {
        return this.heap[0];
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
