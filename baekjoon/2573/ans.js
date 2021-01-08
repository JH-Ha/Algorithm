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
    let m = line1[1];

    let map = [];
    for(let i = 1; i<= n; i ++){
        let line = input[i].split(" ").map(x => parseInt(x));
        map.push(line);
    }
    console.log(map);

}