
const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");
const N = parseInt(input[0]);
var parList = input[1].split(' ').map(function(a){return parseInt(a);}); // 각 인덱스의 부모 리스트
var del = input[2];     // 삭제할 노드


class Node{
    constructor(no){
        this.no = no;
        this.children = [];
    }
    add(child){
        this.children.push(child);
    }
}
var nodes = Array.from({length:N}, (_, i)=>new Node(i));
var root;
parList.forEach(function(par, index){
    if(par==-1) root = index;
    else nodes[par].add(index);
});

var res = 0;
function dfs(node){
    if(nodes[node].children.length==0) return 1; // 리프노드
    if(nodes[node].children.length==1 && nodes[node].children[0]==del) return 1; // 리프노드
    var sum =0;
    nodes[node].children.forEach(function(child){
        if(child!=del)
            sum+=dfs(child);
    });
    return sum;
}
res = dfs(root);
console.log(del==root? 0:res);

//https://develaniper-devpage.tistory.com/51?category=479696