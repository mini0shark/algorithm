public class Yogiyo3 {
    public int solution(int N) {
        N++;
        int n=N;
        int mul = 100000000;
        while(n/mul==0) 
            mul/=10;    // 가장 높은 자리수 찾아내기
        int pre = n/mul;
        n%=mul;
        mul/=10;
        boolean seqIdentical = false;
        int ind =0;
        while(mul>0){
            ind++;
            int now = n/mul;
            if(pre==now){
                seqIdentical=true;
                N+=mul>0?mul:1;
                break;
            }
            n%=mul;
            pre = now;
            mul/=10;
        }
        if(!seqIdentical){
            return N;
        }
        if(mul==1 && N%10>0) return N;
        String numString = Integer.toString(N);
        String resultString;
        char next = '0';
        if(numString.charAt(ind)!='0'){
            ind++;
            resultString = numString.substring(0, ind);
            
            for(int i =ind; i< numString.length(); i++){
                resultString+=next;
                next = next=='0'?'1':'0';
            }
            return Integer.parseInt(resultString);
        } 
        
        resultString = numString.substring(0, ind);
        if(numString.charAt(ind)=='0' && numString.charAt(ind-1)=='0'){
            resultString+='1';
        }
        
        for(int i =ind; i< numString.length(); i++){
            resultString+=next;
            next = next=='0'?'1':'0';
        }
        return Integer.parseInt(resultString);
    }
}
