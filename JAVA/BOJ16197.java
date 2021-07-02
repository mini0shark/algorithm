import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
    int x,y;
    Pair(int y, int x){
        this.x=x;this.y=y;
    }
    Pair(Pair p){
        this.x = p.x;
        this.y = p.y;
    }
    @Override
    public boolean equals(Object obj) {
        Pair p2 = (Pair)obj;
        if(this.x!=p2.x) return false;
        if(this.y!=p2.y) return false;

        return true;
    }
}
class Condition{
    Pair p1=null,p2=null;
    int count;
    Condition(){}
    Condition(Pair p1, Pair p2, int count){
        this.p1 = p1; this.p2=p2;
        this.count = count;
    }
    void pushP(Pair p){
        if(p1==null){
            this.p1=p;
        }else{
            this.p2=p;
        }
    }
}
class BOJ16175{

    public static void checkVisit(Pair p1, Pair p2, boolean[][][][] visit){
        visit[p1.y][p1.x][p2.y][p2.x]=true;
        visit[p2.y][p2.x][p1.y][p1.x]=true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N+2][M+2];
        boolean[][][][] visit = new boolean [N+2][M+2][N+2][M+2];

        Condition c = new Condition();
        for(int i =1; i<= N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                board[i][j]= str.charAt(j-1);
                if(board[i][j]=='o'){
                    c.pushP(new Pair(i, j));
                }
            }
        }

        Queue<Condition> q = new LinkedList<>();
        q.add(c);
        checkVisit(c.p1, c.p2, visit);
        int[] dy = {0 ,1,0,-1};
        int[] dx = {1,0,-1, 0};
        int result =-1;
        while(!q.isEmpty()){
            Condition now = q.poll();
            int cnt = now.count+1;
            if(cnt>10 || result>0){
                break;
            }
            for(int d = 0; d<4; d++){
                Pair p1 = new Pair(now.p1);
                Pair p2 = new Pair(now.p2);
                int fall = 0;
                p1.y += dy[d];p1.x += dx[d];
                p2.y += dy[d];p2.x += dx[d];
                if(board[p1.y][p1.x]=='\u0000'){
                    fall++;
                }
                if(board[p2.y][p2.x]=='\u0000'){
                    fall++;
                }
                if(fall==1){
                    result = cnt;
                    break;
                }
                else if(fall==2){
                    continue;
                }
                if(board[p1.y][p1.x]=='#'){
                    p1.y -= dy[d];
                    p1.x -= dx[d];
                    fall++;
                }
                if(board[p2.y][p2.x]=='#'){
                    p2.y -= dy[d];
                    p2.x -= dx[d];
                    fall++;
                }
                if(fall==2 || p1.equals(p2)){
                    continue;
                }
                if(!visit[p1.y][p1.x][p2.y][p2.x]){
                    q.add(new Condition(p1, p2, cnt));
                }
            }
        }
        System.out.println(result);
    }
}