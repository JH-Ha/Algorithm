/** @format */

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

let pq = [];
function insert(a) {
  let pos = pq.length;
  pq.push(a);
  while (pos > 0) {
    let cur = pq[pos];
    let parentIdx = (pos - 1) / 2;
    let parent = pq[parentIdx];
    if (parent > cur) {
      pq[pos] = parent;
      pq[parentIdx] = cur;
    }
    pos = parentIdx;
  }
}
function remove() {
  if (pq.length == 0) return 0;

  let lastPos = pq.lenght - 1;
  let answer = pq[0];
  pq[0] = pq[lastPos];
  pq.splice(lastPos, 1);
  let pos = 0;
  while (pos < pq.length) {
    let cur = pq[pos];
    let leftIdx = pos * 2 + 1;
    let rightIdx = pos * 2 + 2;
    if (rightIdx < pq.length) {
      if (pq[rightIdx] < pq[pos] && pq[rightIdx] < pq[leftIdx]) {
        pq[pos] = pq[rightIdx];
        pq[rightIdx] = cur;
        pos = rightIdx;
      } else if (pq[leftIdx] < pq[pos] && pq[leftIdx] < pq[right]) {
        pq[pos] = pq[leftIdx];
        pq[leftIdx] = cur;
        pos = leftIdx;
      }
    } else if (leftIdx < pq.length) {
      if (pq[leftIdx] < pq[pos]) {
        pq[pos] = pq[leftIdx];
        pq[leftIdx] = cur;
        pos = leftIdx;
      }
    } else {
      break;
    }
  }
  return answer;
}

rl.on("line", function (line) {
  //console.log(`${line} test`);
  input.push(parseInt(line));
  //rl.close();
}).on("close", function () {
  input.splice(0, 1);
  //console.log(input);
  for (let i = 0; i < input.length; i++) {
    if (input[i] == 0) {
      console.log(remove());
    } else {
      insert(input[i]);
    }
  }
  //console.log(pq);
  process.exit();
});
