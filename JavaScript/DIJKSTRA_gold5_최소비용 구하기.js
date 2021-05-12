const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");

var N = parseInt(input[0].trim());
var M = parseInt(input[1].trim());
var busInfo = Array.from({length:M}, (_,i)=>(input[i+2].trim().split(' ')));
    // [출발도시, 도착도시, 버스비용(0<= x < 100,000)]
var start = input[M+2].trim().split(' ')[0];
var end = input[M+2].trim().split(' ')[1];
const INF = 100000*N+1;

var solution = function(N, M, busInfo, start, end){
    var city = Array.from({length:parseInt(N)+1}, ()=>[]);
    // [출발도시] = [도착도시, 버스비용],[도착도시, 버스비용], [도착도시, 버스비용]...
    busInfo.forEach(function(v, i){
        // v => [출발도시, 도착도시, 버스비용]
        city[v[0]].push([v[1], v[2]]);
    })
    var minDist = Array.from({length:parseInt(N)+1}, ()=>parseInt(INF));
    minDist[start]=0;
    var queue=[];
    queue.push(start);
    while(queue.length>0){
        var now = queue.pop();
        
        city[now].forEach(function(next, i){
            var v = next;
            var dest = v[0];
            var dist = parseInt(v[1]);
            if(minDist[dest]<=minDist[now]+dist) return; //방문 필요X
            minDist[dest] = minDist[now]+dist;
            queue.push(dest);
        })
    }
    return minDist[end];
};

console.log(solution(N, M, busInfo, start, end));