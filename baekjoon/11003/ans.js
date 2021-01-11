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
class Point{
    constructor(x, y){
        this.x = x;
        this.y = y;
    }
}
function query(tree, a, b){
    let ret = 1000000010;
    while(a <= b){
        if(a%2 == 1){
            ret = Math.min(tree[a], ret);
            a ++;
        }
        if(b%2 == 0){
            ret = Math.min(tree[b], ret);
            b --;
        }
        a = Math.floor(a/2);
        b = Math.floor(b/2);
    }
    return ret;
}
function update(tree, a){
    while(a != 0){
        let parent = Math.floor(a/2);
        if(tree[parent] > tree[a]){
            tree[parent] = tree[a];
            a = parent;
        }else{
            break;
        }
    }
}

function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let n = line1[0];
    let l = line1[1];
    
    let arr = input[1].split(" ").map(x => parseInt(x));
    
    let tree = [];
    let baseSize = Math.pow(2,Math.ceil(Math.log2(n)));
    for(let i = 0; i < baseSize; i ++){
        tree.push(1000000010);
    }
    for(let i = 0; i < n; i ++){
        tree.push(arr[i]);
        update(tree, i + baseSize);
    }
    let ans = "";
    for(let i = 0; i < n; i ++){
        let a= i - l + 1 + baseSize;
        if(a < baseSize){
            a = baseSize;
        }
        let b = i + baseSize;
        ans += query(tree, a, b) + " ";
        if(i % 10000 == 0){
            process.stdout.write(ans);
            ans = "";
        }
    }
    console.log(ans.trimEnd());

}