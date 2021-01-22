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

let n;
let l;

function count(map) {
    let ans = 0;
    let used = [];
    for (let i = 0; i < n; i++) {
        let row = [];
        for (let j = 0; j < n; j++) {
            row.push(false);
        }
        used.push(row);
    }
    for (let i = 0; i < n; i++) {
        let valid = true;
        for (let j = 0; j < n - 1; j++) {
            let diff = map[i][j] - map[i][j + 1];
            if (diff == -1) {
                let numSame = 0;
                for (let k = j; k >= 0 && k > j - l; k--) {
                    if (!used[i][k] && map[i][k] == map[i][j]) {
                        numSame++;
                    } else {
                        break;
                    }
                }
                if (numSame != l) {
                    valid = false;
                    break;
                } else {
                    for (let k = j; k > j - l; k--) {
                        used[i][k] = true;
                    }
                }
            } else if (diff == 1) {
                let numSame = 0;
                for (let k = j + 1; k < n && k < j + 1 + l; k++) {
                    if (!used[i][k] && map[i][k] == map[i][j + 1]) {
                        numSame++;
                    } else {
                        break;
                    }
                }
                if (numSame != l) {
                    valid = false;
                    break;
                } else {
                    for (let k = j + 1; k < j + 1 + l; k++) {
                        used[i][k] = true;
                    }
                }
            } else if (diff != 0) {
                valid = false;
                break;
            }
        }
        if (valid)
            ans++;
    }
    return ans;
}

function solve() {
    let line1 = input.shift().split(" ").map(x => parseInt(x));
    n = line1[0];
    l = line1[1];

    let map = [];
    let mapFlip = [];
    for (let i = 0; i < n; i++) {
        let line = input.shift().split(" ").map(x => parseInt(x));
        map.push(line);
    }
    for (let i = 0; i < n; i++) {
        let row = [];
        for (let j = 0; j < n; j++) {
            row.push(map[j][i]);
        }
        mapFlip.push(row);
    }
    //console.log(count(map));
    //console.log(count(mapFlip));
    let ans = count(map) + count(mapFlip);
    console.log(ans);

}