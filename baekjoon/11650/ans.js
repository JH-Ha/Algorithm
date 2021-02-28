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
function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let n = line1[0];
    
    let pointArr = [];
    for(let i = 1; i<= n; i ++){
        let line = input[i].split(" ").map(x => parseInt(x));
        pointArr.push(new Point(line[0], line[1]));
    }
    
    pointArr.sort((a,b)=>{
        if(a.x < b.x){
            return -1;
        }else if(a.x > b.x){
            return a;
        }else{
            return a.y - b.y;
        }
    });
    let ansStr = "";
    pointArr.forEach(ele =>{
        ansStr += ele.x + " "+ ele.y + "\n";
    })
    console.log(ansStr.trimEnd());

}