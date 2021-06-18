public class Programmers68935 {
    // 3진법 뒤집기
    // https://programmers.co.kr/learn/courses/30/lessons/68935
    public int solution(int n) {
        int answer = 0;
        String t = "";
        while(n>0){
            t+=n%3;
            n/=3;
        }
        int mult = 1;
        for(int s =t.length()-1; s>=0; s--){
            int num = t.charAt(s)-'0';
            answer+=num*mult;
            mult*=3;
        }
        return answer;
    }
    
}
