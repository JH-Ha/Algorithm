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

//array priority Queue
// class PriorityQueue{
//     constructor(comp){
//         this.heap = [];
//         if(comp == undefined){
//             this.comp = (a,b) =>{
//                 return a- b;
//             }
//         }else{
//             this.comp = comp;
//         }
//     }
//     push(ele){
//         for(let i = 0; i < this.heap.length; i ++){
//             if(this.comp(ele, this.heap[i]) > 0){
//                 this.heap.splice(i, 0, ele);
//                 return;
//             }
//         }
//         this.heap.push(ele);
//     }
//     pop(){
//         if(!this.isEmpty()){
//             return this.heap.pop();
//         }else{
//             return null;
//         }
//     }
//     isEmpty(){
//         return this.heap.length == 0;

//     }
// }
class PriorityQueue {
  constructor(comp) {
    this.heap = [];
    this.comp = comp;
    if (comp == undefined) {
      this.comp = (a, b) => {
        return a - b;
      };
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
      } else if (
        this.comp(this.heap[this.left(pos)], this.heap[this.right(pos)]) <= 0
      ) {
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

function dij(dp, node, s) {
  dp[s] = 0;
  let pq = new PriorityQueue((a, b) => {
    return a[1] - b[1];
  });
  pq.insert([s, 0]);
  while (!pq.isEmpty()) {
    let top = pq.removeMin();
    let cost = top[1];
    let cur = top[0];
    for (let i = 0; i < node[cur].length; i++) {
      let nextNode = node[cur][i];
      let next = nextNode[0];
      let nCost = nextNode[1];
      if (dp[next] > cost + nCost) {
        dp[next] = cost + nCost;
        pq.insert([next, dp[next]]);
      }
    }
  }
}
function isValid(x, y, N) {
  if (x >= 0 && x < N && y >= 0 && y <= N) {
    return true;
  }
  return false;
}
function solve() {
  for (let t = 1; t < 200; t++) {
    let line = input.shift();
    let line1 = line.split(" ").map((x) => parseInt(x));
    let N = line1[0];
    if (N == 0) break;
    let map = [];
    for (let i = 0; i < N; i++) {
      line = input.shift();
      let row = line.split(" ").map((x) => parseInt(x));
      map.push(row);
    }
    let MAX_NUM = 1000000000;
    let node = [];
    let dp = [];
    for (let i = 0; i <= N * N; i++) {
      dp.push(MAX_NUM);
      node.push([]);
    }
    let dx = [0, 1, 0, -1];
    let dy = [1, 0, -1, 0];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        let idx = i * N + j;
        for (let k = 0; k < 4; k++) {
          let nextX = i + dx[k];
          let nextY = j + dy[k];
          let nextIdx = nextX * N + nextY;
          if (isValid(nextX, nextY, N)) {
            node[idx].push([nextIdx, map[nextX][nextY]]);
          }
        }
      }
    }
    dij(dp, node, 0);
    console.log(`Problem ${t}: ${map[0][0] + dp[N * N - 1]}`);
  }
}
