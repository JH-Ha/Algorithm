const { kMaxLength } = require('buffer');
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
    constructor(x,y){
        this.x = x;
        this.y = y;
    }
}
function isValidPoint(x, y, n, m){
    if(x>=0 && x <n && y >= 0 && y < m){
        return true;
    }
    return false;
}
function solve(){
    let line1 = input[0].split(" ").map(x => parseInt(x));
    let n = line1[0];
    let m = line1[1];

    let map = [];
    let visited = [];
    for(let i = 1; i<= n; i ++){
        let line = input[i].split(" ").map(x => parseInt(x));
        map.push(line);
        let row = [];
        for(let j = 0; j < m; j ++){
            row.push(false);
        }
        visited.push(row);
    }
    let dx = [1,0,-1, 0];
    let dy = [0,1,0, -1];
    let year = null;
    let MAX = 1000000;
    for(year = 0; year < MAX; year ++){
        for(let i = 0; i < n; i++){
            for(let j = 0; j <m; j ++){
                visited[i][j] = false;
            }
        }
        let numIceburg = 0;
        for(let i = 0; i < n; i ++){
            for(let j = 0; j < m; j ++){
                if(map[i][j] != 0 && !visited[i][j]){
                    numIceburg ++;
                    let q = [];
                    //visited[i][j] = true;
                    q.push(new Point(i,j));
                    while(q.length > 0){
                        let front = q.shift();
                        if(visited[front.x][front.y]){
                            continue;
                        }
                        visited[front.x][front.y] = true;
                        for(let k = 0; k < 4; k ++){
                            let nextX = front.x + dx[k];
                            let nextY = front.y + dy[k];
                            if(isValidPoint(nextX, nextY, n, m) && map[nextX][nextY] != 0 && !visited[nextX][nextY]){
                                q.push(new Point(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }
        let nextMap = [];
        for(let i = 0; i < n; i ++){
            let row = [];
            for(let j = 0; j < m; j ++){
                if(map[i][j] != 0){
                    let numAdjIce = 0;
                    for(let k = 0; k < 4; k ++){
                        let adjX = i + dx[k];
                        let adjY = j + dy[k];
                        if(isValidPoint(adjX, adjY, n, m) && map[adjX][adjY] == 0){
                            numAdjIce ++;
                        }
                    }
                    let num = map[i][j] - numAdjIce;
                    if(num < 0){
                        num = 0;
                    }
                    row.push(num);
                }else{
                    row.push(0);
                }
            }
            nextMap.push(row);
        }
        map = nextMap;
        if(numIceburg == 0){
            year = 0;
            break;
        }
        if(numIceburg >= 2){
            break;
        }
    }
    console.log(year);

}