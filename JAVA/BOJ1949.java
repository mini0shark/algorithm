import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1949 {
    static int N;
    static int[] people;
    static boolean[][] link;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        people = new int[N+1];
        link = new boolean[N+1][N+1];
        int[][]dp = new int[N+1][2];
        for(int i =1; i<=N ; i++){
            people[i]=Integer.parseInt(stk.nextToken());
        }
        for(int i =0; i< N-1; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            link[a][b]=true;
            link[b][a]=true;
        }
        check = new boolean[N+1];
        check[1]=true;
        treeDp(dp, 1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }
    
    static void treeDp(int[][] dp, int index){
        if(dp[index][1]>0) return;
        
        for(int i =1; i<= N; i++){
            if(!link[index][i] || check[i]) continue;
            check[i]=true;
            treeDp(dp, i);
            dp[index][1] += dp[i][0];
            dp[index][0] += Math.max(dp[i][0], dp[i][1]);
            check[i]=false;
        }

        dp[index][1]+=people[index];
    }

}
