import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    // 괄호의 값
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
        System.out.println(checkString(str)?calc(str):0);
    }
    public static boolean checkString(String str){
        if(str.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        int len =str.length();
        for(int i =0; i<len; i++){
            char now = str.charAt(i);
            if(now=='('|| now=='['){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(now==')' && top!='('){
                    return false;
                }
                if(now==']' && top!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static int calc(String str){
        if(str.length()==0){
            return 1;
        }
        int start = 0;
        int len = str.length();
        char lt, rt;
        int result;
        int st=0, i =0;
        int ans = 0;
        while(i<len){
            start =i;
            lt = str.charAt(i);
            rt = lt=='('?')':']';
            result = lt=='('?2:3;

            for(; i<len ; i++){
                if(str.charAt(i)==lt) st++;
                if(str.charAt(i)==rt) st--;
                if(st==0){
                    result *= calc(str.substring(start+1, i));
                    break;
                }
            }
            ans+=result;
            i++;
        }
        return ans;
    }
}