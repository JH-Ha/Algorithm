/** @format */

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
    input.push(line);
}).on("close", function () {
    //console.log(input);
    solve();
    process.exit();
});


function solve() {

    let line = input.shift();
    let spt = line.split(" ").map(x => parseInt(x));
    let n = spt[0];
    let m = spt[1];
    let map = [];
    for (let i = 0; i < n; i++) {
        line = input.shift().split("").map(x => parseInt(x));
        map.push(line);
    }
    let k = parseInt(input.shift());
    let ans = 0;
    for (let i = 0; i < n; i++) {
        let isOneRow = true;
        for (let j = 0; j < m; j++) {
            if (map[i][j] == 0) {
                isOneRow = false;
                break;
            }
        }
        if (isOneRow) {
            ans++;
        }
    }
    for (let i = 0; i < n; i++) {
        let zeroIdx = [];
        for (let j = 0; j < m; j++) {
            if (map[i][j] == 0) {
                zeroIdx.push(j);
            }
        }
        if (zeroIdx.length > k) {
            continue;
        } else if (zeroIdx.length != 0 && (k % zeroIdx.length) % 2 == 1) {
            continue;
        }
        let mapCopy = [];
        for (let x = 0; x < n; x++) {
            let row = [];
            for (let y = 0; y < m; y++) {
                let isZero = false;
                for (let z = 0; z < zeroIdx.length; z++) {
                    if (y == zeroIdx[z]) {
                        isZero = true;
                        break;
                    }
                }
                if (isZero) {
                    row.push(1 - map[x][y]);
                } else {
                    row.push(map[x][y]);
                }
            }
            mapCopy.push(row);
        }
        let numOneRow = 0;
        for (let x = 0; x < n; x++) {
            let isOneRow = true;
            for (let y = 0; y < m; y++) {
                if (mapCopy[x][y] == 0) {
                    isOneRow = false;
                    break;
                }
            }
            if (isOneRow) {
                numOneRow++;
            }
        }
        ans = Math.max(numOneRow, ans);
    }
    console.log(ans);

}
