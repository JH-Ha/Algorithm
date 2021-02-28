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

class Node {

    constructor(id) {
        this.id = id;
        this.parentCnt = 0;
        this.children = [];
    }
}

function solve(input) {

    var spt = input[0].split(' ');
    var n = parseInt(spt[0]);
    var m = parseInt(spt[1]);


    var nodeArr = [];
    var used = [];
    for (let i = 0; i <= n; i++) {
        nodeArr.push(new Node(i));
        used.push(false);
    }
    for (let i = 1; i < 1 + m; i++) {
        spt = input[i].split(' ');
        for (let j = 1; j < spt.length - 1; j++) {
            var l = parseInt(spt[j]);
            var r = parseInt(spt[j + 1])

            nodeArr[r].parentCnt++;
            nodeArr[l].children.push(r);
        }
    }
    ans = [];
    for (let j = 0; j < n; j++) {
        // nodeArr.sort((a, b) => {
        //     return a.parentCnt - b.parentCnt;
        // });
        q = []
        for (let i = 1; i < nodeArr.length; i++) {
            if (!used[nodeArr[i].id] && nodeArr[i].parentCnt == 0)
                q.push(nodeArr[i]);
        }
        for (let i = 0; i < q.length; i++) {
            ans.push(q[i].id);
            used[q[i].id] = true;
            for (let k = 0; k < q[i].children.length; k++) {

                nodeArr[q[i].children[k]].parentCnt--;
            }
        }
    }
    if (ans.length != n)
        console.log(0);
    else {
        for (let i = 0; i < ans.length; i++) {
            console.log(ans[i]);
        }
    }
}