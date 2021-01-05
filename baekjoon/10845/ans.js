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
class NodeQueue{
    constructor(value){
        this.prev = null;
        this.next = null;
        this.value = value;
    }
}
class Queue{
    constructor (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    enqueue(value){
        let nodeQueue = new NodeQueue(value);
        if(this.size == 0){
            this.head = nodeQueue;
        }else{
            this.tail.next = nodeQueue;
        }
        this.tail = nodeQueue;
        this.size++;
    }
    dequeue(){
        if(this.size== 0){
            return null;
        }
        let value = this.head.value;
        this.head = this.head.next;
        this.size--;
        if(this.size == 0){
            this.tail = null;
        }
        return value;
    }
    isEmpty(){
        return this.size == 0;
    }
}

function solve(){
    let output = "";
    let q = new Queue();
    for(let i = 1; i < input.length; i ++){
        let line = input[i];
        if(line.startsWith("push")){
            let spt = line.split(" ");
            q.enqueue(spt[1]);
        }else if(line.startsWith("pop")){
            if(q.isEmpty()){
                output += -1 + "\n";
            }else{
                output += q.dequeue() +"\n";
            }
        }else if(line.startsWith("front")){
            if(q.isEmpty()){
                output += -1 + "\n";
            }else{
                output += q.head.value + "\n";
            }
        }else if(line.startsWith("size")){
            output += q.size + "\n";
        }else if(line.startsWith("empty")){
            if(q.isEmpty())
                output+= 1 + "\n";
            else{
                output+= 0 + "\n";
            }
        }else if(line.startsWith("back")){
            if(q.isEmpty()){
                output+= -1 + "\n";
            }else{
                output+= q.tail.value + "\n";
            }
        }
    }
    console.log(output.trimEnd());
}