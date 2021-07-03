import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int K, M, P;
            K = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            P = Integer.parseInt(stk.nextToken());
            ArrayList<Integer>[] info = new ArrayList[M];
            int[][] count = new int[M][M];
            int [] node = new int[M];
            for(int i =0; i<M; i++){
                info[i] = new ArrayList<>();
            }
            for(int i =0; i< P; i++){
                stk = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                a--;b--;
                info[a].add(b);
                node[b]++;
            }
            Queue<Integer> q = new LinkedList<>();

            for(int i =0; i< M; i++){
                if(node[i]!=0)  continue;
                q.add(i);
                count[i][1]=1;
            }
            int result =0;
            while(!q.isEmpty()){
                int nodeIndex = q.poll();
                int ci = findMax(count[nodeIndex], M);
                if(count[nodeIndex][ci]>=2){
                    ci++;
                    count[nodeIndex][ci]=1;   // 순서가 i인 강이 2개 이상일 때 i+1을 순서로
                }
                result = Math.max(ci, result);
                
                for(int in: info[nodeIndex]){
                    count[in][ci]++;
                    if(--node[in]==0){
                        q.add(in);
                    }
                }

            }
            System.out.println(K+" "+result);


        }


    }
    static int findMax(int[] arr, int m){
        int max = 0;
        for(int i = m-1; i>=0; i--){
            if(arr[i]>0){
                max=i;
                break;
            }
        }
        return max;
    }
}