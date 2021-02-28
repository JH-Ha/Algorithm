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
class PriorityQueue{
    constructor(comp){
        this.heap = [];
        this.comp = comp;
        if(comp == undefined){
            this.comp = (a,b) =>{
                return a - b;
            }
        }
    }
    removeMin(){
        if(this.isEmpty()){
            return null;
        }
        let min = this.heap[0];
        let last = this.heap.pop();
        if(this.size() != 0){
            this.heap[0] = last;
            this.downHeap(0);
        }
        return min;
    }
    downHeap(pos){
        while(this.isInternal(pos)){
            let s = null;

            //왼쪽과 오른쪽 자식중에 작은 것을 s에 넣는다.
            if(!this.hasRight(pos)){
                s = this.left(pos);
            }else if(this.comp(this.heap[this.left(pos)], this.heap[this.right(pos)])<= 0){
                s = this.left(pos);
            }else{
                s = this.right(pos);
            }
            if(this.comp(this.heap[s], this.heap[pos]) < 0){
                this.swap(pos, s);
                pos = s;
            }else{
                break;
            }
        }
    }
    upHeap(pos){
        while(!this.isRoot(pos)){
            let p = this.parent(pos);
            if(this.comp(this.heap[p], this.heap[pos])<= 0){
                break;
            }
            this.swap(p, pos);
            pos = p;
        }
    }
    swap(x, y){
        let tmp = this.heap[x];
        this.heap[x] = this.heap[y];
        this.heap[y] = tmp;
    }
    parent(pos){
        return parseInt((pos - 1)/2);
    }
    left(pos){
        return 2*pos + 1;
    }
    right(pos){
        return 2*pos + 2;
    }
    size(){
        return this.heap.length;
    }
    isInternal(pos){
        return this.hasLeft(pos) ;
    }
    isRoot(pos){
        if(pos == 0) return true;
        return false;
    }
    hasLeft(pos){
        if(this.left(pos) < this.size()){
            return true;
        }
        return false;
    }
    hasRight(pos){
        if(this.right(pos) < this.size()){
            return true;
        }
        return false;
    }
    isEmpty(){
        return this.heap.length == 0;
    }
    insert(value){
        this.heap.push(value);
        this.upHeap(this.size() - 1);
    }
    min(){
        return this.heap[0];
    }
}

function dij(dp, node, s){
    dp[s][s] = 0;
    let pq = new PriorityQueue((a, b)=>{
        return a[1] - b[1];
    });
    pq.insert([s, 0]);
    while(!pq.isEmpty()){
        let top = pq.removeMin();
        let cost = top[1];
        let cur = top[0];
        for(let i = 0; i < node[cur].length; i ++){
            let nextNode = node[cur][i];
            let next = nextNode[0];
            let nCost = nextNode[1];
            if(dp[s][next] > cost + nCost){
                dp[s][next] = cost + nCost;
                pq.insert([next, dp[s][next]]);
            }
        }
    }
}

function solve(){
    let line = input.shift();
    let line1 = line.split(" ").map(x => parseInt(x));
    let T = line1[0];
    let globalAns = [];
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
                //continue;
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
        //console.log(dest);
        let dp = [];
        let MAX_NUM = 2000000000;
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
        // s -> g -> h -> 후보지
        // s -> h -> g -> 후보지
        let ans = "";
        for(let i = 0; i < t; i ++){
            let final = dest[i];
            let distance = dp[s][g] + ghDistance + dp[h][final];
            let distance2 = dp[s][h] + ghDistance + dp[g][final];
            let minDis = Math.min(distance, distance2);
            if(minDis == MAX_NUM) continue;
            if(minDis == dp[s][final]){
                ans += final + " ";
            }
        }
        globalAns += ans + '\n';
    }
    console.log(globalAns.trimEnd());
    
}