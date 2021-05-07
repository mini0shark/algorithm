const input = require("fs").readFileSync("./dev/stdin").toString().trim().split("\n");

const temp =input[0].trim().split(' ').map(function(a){return parseInt(a)});
const N=temp[0],M= temp[1];
input.shift();  // 첫번째 줄 제거
var board = Array.from({length:N+2}, (i)=>Array.from({length:M+2}, (_,i)=>' '));
var map = new Map();
class Coin{
    constructor(y,x){
        this.y = y;
        this.x = x;
    }
}
class State{
    constructor(coins, count){
        this.coins = coins;
        this.count = count;
    }
}
var coins = [];
input.forEach(function(str, i){
    var line = i+1;
    var curStr = str.trim();
    for(var i =0 ; i< M; i++){
        board[line][i+1] = str[i];
        if(str[i]=='o') coins.push(new Coin(line,i+1));
    }
});

var check = new Set();
check.add(coins[0].y+'-'+coins[0].x+'-'+coins[1].y+'-'+coins[1].x);
check.add(coins[1].y+'-'+coins[1].x+'-'+coins[0].y+'-'+coins[0].x);
var queue = [];
queue.push(new State(coins, 0));

var dy = [0,0,1,-1];
var dx = [1,-1,0,0];
var res =-1;
while(queue.length>0){
    var cur = queue.shift();
    var coin1 = cur.coins[0];
    var coin2 = cur.coins[1];
    var count = cur.count;
    count++;
    if(count>10) continue;
    for(var i =0; i< 4; i++){
        var ny1 = coin1.y+dy[i];
        var nx1 = coin1.x+dx[i];
        var ny2 = coin2.y+dy[i];
        var nx2 = coin2.x+dx[i];
        if(check.has([ny1]+'-'+[nx1]+'-'+[ny2]+'-'+[nx2])) continue; // 이전에 들른 곳
        check.add([ny1]+'-'+[nx1]+'-'+[ny2]+'-'+[nx2]);
        check.add([ny2]+'-'+[nx2]+'-'+[ny1]+'-'+[nx1]);
        if(board[ny1][nx1]==' ' && board[ny2][nx2]==' '){   // 둘다 떨어지면 안됨
            continue;
        }else if(board[ny1][nx1]==' ' || board[ny2][nx2]==' '){  // 둘 중 하나만 떨어지면 끝
            res = count;
            break;
        }
        if(board[ny1][nx1]=='#' && board[ny2][nx2]=='#') continue;  // 움직이지 못하므로 생략
        if(board[ny1][nx1]=='#'){   // 다음 목표가 벽이면 움직이지 않음
            ny1=coin1.y;
            nx1=coin1.x;
        }
        if(board[ny2][nx2]=='#'){   // 다음 목표가 벽이면 움직이지 않음
            ny2=coin2.y;
            nx2=coin2.x;
        }
        if(ny1==ny2 && nx1==nx2) continue;
        queue.push(new State([new Coin(ny1,nx1),new Coin(ny2,nx2)], count));
    }
    if(res>0) break;
}

console.log(res);

//https://develaniper-devpage.tistory.com/50