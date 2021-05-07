const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");
const line = input[0].trim().split(' ');
const H = line[0], W = line[1];
const block = input[1].toString().trim().split(' ').map(function(a){return parseInt(a)});

let stack = [];

let sum=0;
let h;  // 기준 높이
block.forEach(function(b, i){
    if(stack.length==0){
        stack.push(b);
        h = b;
        return;
    }
    if(stack[0]<= b){   // 기준 높이보다 높거나 같은게 나왔을 때.
                        // 기준 vs 현재
        while(stack.length>0){
            let top = stack.pop();
            sum += h-top;
        }
        h = b;
    }
    stack.push(b);
});
if(stack.length>0){
    h = stack.pop();
    
    while(stack.length>0){
        let top = stack.pop();
        if(h<=top){
            h = top;
            continue;
        }
        sum += h-top;
    }
}
console.log(sum);

// https://develaniper-devpage.tistory.com/57