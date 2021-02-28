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


let A = [];
function  manachers(S, N)
{
    let r = 0;
    let p = 0;
    for (let i = 0; i < N; i++)
    {
        if (i <= r)
            A[i] = Math.min(A[2 * p - i], r - i);
        else
            A[i] = 0;

        while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N && S[i - A[i] - 1] == S[i + A[i] + 1])
            A[i]++;

        if (r < i + A[i])
        {
            r = i + A[i];
            p = i;
        }
    }
}

function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let n = line1[0];
    
    
    let str = input[1].split(" ").reduce((a, b)=>{
        return a +"#"+ b  ;
    });
    str = str + "#";
    // str = input[1].split(" ").reduce((a,b)=>{
    //     return a+ b;
    // });
    let sLen = str.length;

    for(let i = 0; i < sLen; i ++){
        A.push(0);
    }
    
    manachers(str, sLen - 1);

    
    let m = parseInt(input[2]);
    let ans = "";
    for(let i = 3; i < 3+ m; i ++){
        let query = input[i].split(" ").map(x => parseInt(x));
        let s = (query[0]-1) * 2 ;
        let e = (query[1]-1) * 2 ;
        let center = Math.floor((s + e)/2);
        if(A[center] + center >= e){
            //console.log(1);
            ans += "1\n";
        }else{
            //console.log(0);
            ans += "0\n";
        }
    }
    console.log(ans);

}