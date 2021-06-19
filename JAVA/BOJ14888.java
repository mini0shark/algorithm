import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int N;
    static int[] nums, op;
    static int min = 1000000000, max=-1000000000;
    public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		op = new int[4];		// + - * /
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
        dfs(nums[0], 1);
        System.out.println(max+"\n"+min);
        
    }

    public static void dfs(int result, int index){
        if(op[0]==0 &&op[1]==0 && op[2]==0 &&op[3]==0){
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }
        for(int i =0; i<4; i++){
            if(op[i]<=0) continue;
            int temp=0;
            switch(i){
                case 0:temp=result+nums[index];break;
                case 1:temp=result-nums[index];break;
                case 2:temp=result*nums[index];break;
                case 3:temp=result/nums[index];break;
            }
            op[i]--;
            dfs(temp, index+1);
            op[i]++;
        }
    }
}
