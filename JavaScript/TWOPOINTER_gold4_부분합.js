const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");

var line1 = input[0].trim().split(' ');
var arr = input[1].trim().split(' ').map(function(a){return parseInt(a);});

var N = line1[0];
var S = line1[1];
arr.unshift(0);

var solution = function(N, S, arr){
    var prefSum = Array.from({length: parseInt(N)+1}, (v, i)=>0);
    prefSum.forEach(function(_,i){
        if(i==0) return;
        prefSum[i]+=prefSum[i-1]+arr[i];
    });

    if(prefSum[N]<S){    // 모든 수의 합이 목표(S)보다 작을 때
        return 0;
    }
    var lt = 0; rt = 0;
    var res=N;
    while(rt<=N){
        if(prefSum[rt]-prefSum[lt]<S){
            rt++;
        }else{
            res = Math.min(res,(rt-lt));
            lt++;
        }
    }
    return res;
}

console.log(solution(N, S, arr))