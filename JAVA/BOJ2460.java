import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ2460 {
    public static void main(String[] args) throws IOException{
        int people = 0;
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i =0; i<10; i++){
            st  = new StringTokenizer(br.readLine()," ");
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            people-=out;
            people+=in;
            max = Math.max(people, max);
        }
        System.out.println(max);
    }
}
