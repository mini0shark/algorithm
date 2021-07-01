import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =1; i<=N; i++){
            sum[i]= Integer.parseInt(st.nextToken());
            sum[i]+=sum[i-1];
        }
        if(sum[N]<S){
            System.out.println(0);
        }else{
            int lt = 0, rt = 1;
            int res = N;
            while(rt<=N){
                if(sum[rt]-sum[lt]<S){
                    rt++;
                }else{
                    res = Math.min(res, rt-lt);
                    lt++;
                }
            }
            System.out.println(res);
        }

    }
}
