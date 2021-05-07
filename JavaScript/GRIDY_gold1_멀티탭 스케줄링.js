const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");
const line1 = input[0].trim().split(' ');
const N = parseInt(line1[0]), K = parseInt(line1[1]);
if(N>=K){
    console.log(0);return;
}

const arr = input[1].trim().split(' ').map(function(a, i){return parseInt(a)});
let plug = Array.from({length:N}, ()=> K+1);    // 인덱스를 저장


let nextArr = Array.from({length:K+1}, ()=>(K+1));
let nextLoad = Array.from({length:K+1}, ()=>(K+1));
for(let i = K-1 ; i>=0; i-- ){
    nextArr[i] =nextLoad[arr[i]];
    nextLoad[arr[i]] = i;
}


let cnt = 0;
arr.forEach(function(obj, ind){
    let target = -1;
    let amt = 0;
    for(let i =0; i<N; i++){
        let num = arr[plug[i]];  // 전자기기 번호
        let index = plug[i];    // arr에서의 인덱스
        if(num==obj){  //플러그에 꼳혀있으면
            plug[i] = ind;
            return;
        }
        if(plug[i]===K+1){
            plug[i] = ind;
            return;
        }else if(amt<nextArr[index]){   // 다음 인덱스
            amt = nextArr[index];
            target = i;
        }
    }
    if(target>=0){
        cnt++;
    }
    plug[target]=ind;
});
console.log(cnt);

// https://develaniper-devpage.tistory.com/58