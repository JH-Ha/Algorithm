class PriorityQueue{
    constructor(comp){
        this.heap = [];
        if(comp == undefined){
            this.comp = (a,b) =>{
                return a- b;
            }
        }else{
            this.comp = comp;
        }
    }
    push(ele){
        for(let i = 0; i < this.heap.length; i ++){
            if(this.comp(ele, this.heap[i]) > 0){
                this.heap.splice(i, 0, ele);
                return;
            }
        }
        this.heap.push(ele);
    }
    pop(){
        if(!this.isEmpty()){
            return this.heap.pop();
        }else{
            return null;
        }
    }
    isEmpty(){
        return this.heap.length == 0;
            
    }
}

let pq = new PriorityQueue();
pq.push(2);
pq.push(1);
pq.push(3);
pq.push(0);
pq.push(5);
pq.push(6);
pq.push(7);
while(!pq.isEmpty()){
    console.log(pq.pop());
}