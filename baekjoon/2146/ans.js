const { group } = require('console');
const { appendFileSync } = require('fs');
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
let map = [];
let visited = [];

function isValid(x, y) {
    if (x >= 0 && y >= 0 && x < n && y < n) {
        return true;
    }
    return false;
}
class Point {
    constructor(x, y, depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
let dx = [0, 1, 0, -1];
let dy = [1, 0, -1, 0];
let dist = [];
function bfs(x, y, groupId) {
    let q = [];

    q.push(new Point(x, y, 0));
    visited[x][y] = groupId;
    while (!q.length == 0) {
        let top = q.shift();
        //visited[x][y] = groupId;

        for (let k = 0; k < 4; k++) {
            let nextX = top.x + dx[k];
            let nextY = top.y + dy[k];
            if (isValid(nextX, nextY) && visited[nextX][nextY] == 0 && map[nextX][nextY] == 1) {
                visited[nextX][nextY] = groupId;
                q.push(new Point(nextX, nextY, top.depth + 1));
            }
        }
    }
}

function bfsFindOtherGroup(x, y, groupId) {
    let q = [];

    q.push(new Point(x, y, 0));
    let bfsVisited = [];
    for (let i = 0; i < n; i++) {
        let row = [];
        for (let j = 0; j < n; j++) {
            row.push(false);
        }
        bfsVisited.push(row);
    }

    let hasZero = false;
    for (let k = 0; k < 4; k++) {
        let nextX = x + dx[k];
        let nextY = y + dy[k];
        if (isValid(nextX, nextY) && map[nextX][nextY] == 0) {
            hasZero = true;
        }
    }
    if (!hasZero) {
        return;
    }
    while (!q.length == 0) {
        let top = q.shift();
        //visited[x][y] = groupId;
        if (visited[top.x][top.y] != 0 && visited[top.x][top.y] != groupId) {
            dist[x][y] = top.depth;
            break;
        }

        for (let k = 0; k < 4; k++) {
            let nextX = top.x + dx[k];
            let nextY = top.y + dy[k];

            if (isValid(nextX, nextY) && !bfsVisited[nextX][nextY]) {
                bfsVisited[nextX][nextY] = true;
                q.push(new Point(nextX, nextY, top.depth + 1));
            }
        }

    }
}

function solve() {
    let line1 = input.shift().split(" ").map(x => parseInt(x));
    n = line1[0];

    for (let i = 0; i < n; i++) {
        let line = input.shift().split(" ").map(x => parseInt(x));
        map.push(line);
    }
    for (let i = 0; i < n; i++) {
        let row = [];
        let row2 = [];
        for (let j = 0; j < n; j++) {
            row.push(0);
            row2.push(0);
        }
        visited.push(row);
        dist.push(row2);
    }
    let groupId = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (map[i][j] == 1 && visited[i][j] == 0) {
                bfs(i, j, ++groupId);
            }
        }
    }
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (visited[i][j] != 0)
                bfsFindOtherGroup(i, j, visited[i][j]);
        }
    }
    //console.log(visited);
    //console.log(dist);

    let ans = 10100;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (dist[i][j] != 0)
                ans = Math.min(ans, dist[i][j]);
        }
    }
    console.log(ans - 1);

}