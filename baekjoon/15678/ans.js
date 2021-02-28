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

function query(tree, baseSize, start, end){
    let s = baseSize + start;
    let e = baseSize + end;
    let ret = -1000000010;
    while(s < e){
        if(s % 2 == 1){
            ret = Math.max(ret, tree[s]);
            s = s + 1;
        }
        if(e % 2 ==  0){
            ret = Math.max(ret, tree[e]);
            e = e - 1;
        }
        s = Math.floor(s/2);
        e = Math.floor(e/2);
    }
    ret = Math.max(ret, tree[s]);
    return ret;
}
function update(tree, pos){
    while(pos != 0){
        let parent = Math.floor(pos/2);
        if(tree[parent] < tree[pos]){
            tree[parent] = tree[pos];
            pos = parent;
        }else{
            break;
        }
    }
}

function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let n = line1[0];
    let d = line1[1];
    let arr = input[1].split(" ").map(x => parseInt(x));

    let twoExp = Math.ceil(Math.log2(n));
    let baseSize = Math.pow(2, twoExp);
    let tree = [];
    for(let i = 0; i < baseSize; i ++){
        tree.push(-1000000010);
    }
    
    for(let i = baseSize; i < baseSize + n; i ++){
        tree[i] = arr[i - baseSize];
    }
    update(tree, baseSize);
    let answer = tree[baseSize];
    for(let i = 1; i < n; i ++){
        let start = i - d;
        if(start < 0){
            start = 0;
        }
        let end = i - 1;
        let qResult = query(tree,baseSize, start, end) ;
        tree[baseSize + i] = Math.max(qResult + arr[i], arr[i]);
        answer = Math.max(answer, tree[baseSize + i]);
        update(tree, baseSize + i);
    }
    console.log(answer);
    //console.log(tree);
    

}