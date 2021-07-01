import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2023{
    static int N;
    static ArrayList<Integer> al = new ArrayList<>();

    public static boolean isPrime(int number){
        if(number<=1) return false;
        for(int i =2; i*i <=number; i++){
            if(number%i==0) return false;
        }
        return true;
    }

    public static void nextComb(int comb, int n){
        if(n==N){
            al.add(comb);
            return;
        }
        comb*=10;
        for(int i =0; i<=9; i++){
            if(isPrime(comb+i)){
                nextComb(comb+i, n+1);
            }
        }        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nextComb(0, 0);
        Collections.sort(al);
        for(int i : al)
            System.out.println(i);
    }
}