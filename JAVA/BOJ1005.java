import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> resultSet = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        while(T-- > 0){
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            int W;
            int [] building = new int[N];
            int [] time = new int[N];
            ArrayList<Integer> [] al = new ArrayList[N];
            stk= new StringTokenizer(br.readLine());
            for(int i =0; i< N; i++){
                al[i]=new ArrayList<Integer>();
                time[i]= Integer.parseInt(stk.nextToken());
            }
            for(int i =0; i< K; i++){
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                a--;b--;
                al[a].add(b);
                building[b]++;
            }
            W = Integer.parseInt(br.readLine());

            Queue<Integer[]> queue = new LinkedList<>();
            int [] resultTime = new int[N];
            for(int i =0; i<N; i++){
                if(building[i]>0) continue;
                Integer[] inq = {i, time[i]};
                resultTime[i] = time[i];
                queue.add(inq);
            }

            while(!queue.isEmpty()){
                Integer[] now = queue.poll();
                for(int a : al[now[0]]){
                    resultTime[a] = Math.max(resultTime[a], resultTime[now[0]]+time[a]);
                    if(--building[a] ==0){
                        Integer[] newQ = {a, resultTime[a]};
                        queue.add(newQ);
                    }
                }
            }
            resultSet.add(resultTime[W-1]);
        }
        for(int I : resultSet){
            System.out.println(I);
        }
    }
}
