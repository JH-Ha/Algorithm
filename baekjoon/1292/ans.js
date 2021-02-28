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

function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let a = line1[0];
    let b = line1[1];
    
    let arr = [];
    let cnt = 1;
    let curCnt = 0;
    for(let i = 0; i < 1000; i ++){
        if(cnt <= curCnt){
            cnt ++;
            curCnt = 1;
        }
        else{
            curCnt ++;
        }
        arr.push(cnt);
    }
    let ans = 0;
    for(let i = a - 1; i < b; i ++){
        ans += arr[i];
    }
    console.log(ans);

}