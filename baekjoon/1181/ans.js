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
    let n = line1[0];
    
    let map = [];
    for(let i = 1; i<= n; i ++){
        let line = input[i];
        map.push(line);
    }
    //중복 제거
    let set = new Set(map);
    let ans = [];
    set.forEach(a =>{
        ans.push(a);
    });
    ans.sort((a,b)=>{
        if(a.length < b.length){
            return -1;
        }else if(a.length > b.length){
            return a;
        }else{
            for(let i = 0; i < a.length; i ++){
                if(a.charCodeAt(i) < b.charCodeAt(i)){
                    return -1;
                }else if(a.charCodeAt(i) > b.charCodeAt(i)){
                    return 1;
                }
            }
            return 0;
        }
    });
    let ansStr = "";
    ans.forEach(ele =>{
        ansStr += ele + "\n";
    })
    console.log(ansStr.trimEnd());

}