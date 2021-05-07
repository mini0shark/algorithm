const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");

function checkRight(string){
    if(string.length%2==1) return false;
    let stack = [];
    for(let s in string){
        if(string[s]==='(' || string[s]==='['){
            stack.push(string[s]);
        }else{
            if(stack.length===0) return false;
            if(string[s]===')'){
                let cur = stack.pop();
                if(cur!=='(') return false;
            }else{
                let cur = stack.pop();
                if(cur!=='[') return false;
            }
        }
    }
    return stack.length===0;      // 모든 괄호를 검사 후 스택에 값이 하나라도 있으면 false
}

function devConq(string){
    if(string ==='') return 1;
    let sum =0;
    let stack = [];
    let st=0;
    for(let s in string){
        if(string[s]==='(' || string[s]==='['){
            stack.push(string[s]);
        }else{
            stack.pop();
        }
        if(s!=0 && stack.length===0){
            let cur = devConq(string.substring(st+1, parseInt(s)));
            if(string[s]==')'){
                sum+=2*cur;
            }else{
                sum+=3*cur;
            }
            st = parseInt(s)+1;
        }
    }
    return sum;
}

if(!checkRight(input[0])) console.log('0');
else console.log(devConq(input[0]));

// https://develaniper-devpage.tistory.com/56