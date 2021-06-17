public class Programers77484 {
    // 로또의 최고 순위와 최저 순위
    // https://programmers.co.kr/learn/courses/30/lessons/77484
    int rank(int num){
        if(num<2) return 6;
        return 7-num;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] winNums = new boolean[46];
        for(int i =0; i< 6; i++){
            winNums[win_nums[i]]=true;
        }

        int zero=0, win=0;
        for(int i =0; i< 6; i++){
            if(lottos[i]==0) zero++;
            else if(winNums[lottos[i]]) win++;
        }
        answer[0]= rank(zero+win);
        answer[1]=rank(win);
        return answer;
    }
}
