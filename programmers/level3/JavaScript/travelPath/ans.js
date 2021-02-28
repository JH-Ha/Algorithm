class Ticket{
    constructor(airport, id){
        this.airport = airport;
        this.id = id;
    }
}

var solved = false;
var ansLen;
function find(dict, visited, cur, ans){
    let children = dict[cur];
    if(children != undefined){
        for(let i = 0; i < children.length; i ++){
            let child = children[i];
            if(!visited[child.id]){
                visited[child.id] = true;
                ans.push(child.airport);
                find(dict, visited, child.airport, ans);
                if(solved){
                    return;
                }
                ans.pop();
                visited[child.id] = false;
            }
        }
    }
    if(ans.length == ansLen){
        solved = true;
    }
}

function solution(tickets) {
    var answer = [];
    var dict = {};
    var visited = {};
    var id = 0;
    for(let i = 0; i < tickets.length; i ++){
        let ticket = tickets[i];
        if(dict[ticket[0]] == undefined){
            dict[ticket[0]] = [];
        }
        dict[ticket[0]].push(new Ticket(ticket[1], id));
        visited[id] = false;
        id ++;
    }
    //알파벳 순으로 정렬
    for(let key in dict){
        dict[key].sort((a,b)=>{
            if(a.airport < b.airport){
                return -1;
            }else if(a.airport > b.airport){
                return 1;
            }
            return 0;
        });
    }
    solved = false;
    ansLen = tickets.length + 1;
    answer.push('ICN');
    find(dict, visited, 'ICN',answer);

    return answer;
}

//var tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]];
var tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]];
//var tickets = [["ICN","A"],["ICN","A"],["A","ICN"]];

console.log(solution(tickets));