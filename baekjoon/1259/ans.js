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
        solve(input);
        process.exit();
    });

function solve(input){
    for(let i = 0; i < input.length - 1; i ++){
        let isPalindrom = true;
        let size = input[i].length;
        for(let j = 0; j < size/2; j ++){
            if(input[i][j] != input[i][size - j - 1]){
                isPalindrom = false;
                break;
            }
        }
        if(isPalindrom){
            console.log("yes");
        }else{
            console.log("no");
        }
    }
}