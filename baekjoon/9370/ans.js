const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input.push(line)
})
    .on('close', function () {
        //console.log(input);
        solve();
        process.exit();
    });

//array priority Queue
class PriorityQueue{
    constructor(comp){
        this.heap = [];
        if(comp == undefined){
            this.comp = (a,b) =>{
                return a- b;
            }
        }else{
            this.comp = comp;
        }
    }
    push(ele){
        for(let i = 0; i < this.heap.length; i ++){
            if(this.comp(ele, this.heap[i]) > 0){
                this.heap.splice(i, 0, ele);
                return;
            }
        }
        this.heap.push(ele);
    }
    pop(){
        if(!this.isEmpty()){
            return this.heap.pop();
        }else{
            return null;
        }
    }
    isEmpty(){
        return this.heap.length == 0;
            
    }
}
function dij(dp, node, s){
    dp[s][s] = 0;
    let pq = new PriorityQueue((a, b)=>{
        return a[1] - b[1];
    });
    pq.push([s, 0]);
    while(!pq.isEmpty()){
        let top = pq.pop();
        let cost = top[1];
        let cur = top[0];
        for(let i = 0; i < node[cur].length; i ++){
            let nextNode = node[cur][i];
            let next = nextNode[0];
            let nCost = nextNode[1];
            if(dp[s][next] > cost + nCost){
                dp[s][next] = cost + nCost;
                pq.push([next, dp[s][next]]);
            }
        }
    }
}

function solve(){
    let line = input.shift();
    let line1 = line.split(" ").map(x => parseInt(x));
    let T = line1[0];
    while(T-- > 0){
        line = input.shift();
        line1 = line.split(" ").map(x => parseInt(x));
        let n = line1[0];
        let m = line1[1];
        let t = line1[2];
        line = input.shift();
        line1 = line.split(" ").map(x => parseInt(x));
        let s = line1[0];
        let g = line1[1];
        let h = line1[2];

        let node = [];
        let ghDistance = 0;
        for(let i = 0; i <= n; i ++){
            node.push([]);
        }
        for(let i = 0; i < m; i ++){
            line = input.shift();
            line1 = line.split(" ").map(x => parseInt(x));
            let a = line1[0];
            let b = line1[1];
            let d = line1[2];
            if((a == g && b == h ) || (a == h && b == g)){
                ghDistance = d;
                continue;
            }
            node[a].push([b,d]);
            node[b].push([a,d]);
        }
        let dest = [];
        for(let i = 0; i < t; i ++){
            line = input.shift();
            line1 = line.split(" ").map(x => parseInt(x));
            dest.push(line1[0]);
        }
        dest.sort();
        console.log(dest);
        let dp = [];
        let MAX_NUM = 1000000000;
        for(let i = 0; i <= n; i ++){
            let row = [];
            for(let j = 0; j<=n; j ++){
                row.push(MAX_NUM);
            }
            dp.push(row);
        }
        dij(dp, node, s);
        dij(dp, node, g);
        dij(dp, node, h);
        let ansList = [];
        // s -> g -> h -> 후보지
        // s -> h -> g -> 후보지
        let minDistance = MAX_NUM;
        for(let i = 0; i < t; i ++){
            let final = dest[i];
            let distance = dp[s][g] + ghDistance + dp[h][final];
            let distance2 = dp[s][h] + ghDistance + dp[g][final];
            ansList.push([final, distance]);
            ansList.push([final, distance2]);
            minDistance = Math.min(distance, minDistance);
            minDistance = Math.min(distance2, minDistance);
        }
        
    }
}