import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.TypeInfo;

public class Programmers72411 {
    // 메뉴 리뉴얼
    // https://programmers.co.kr/learn/courses/30/lessons/72411
    int[] menuList;
    public void dfs(String order, int comb, int index){
        menuList[comb]++;
        for(int i =index+1; i< order.length(); i++){
            dfs(order, (comb|(1<<(order.charAt(i)-'A'))), i);
        }
    }
    public String getRes(int result){
        String res ="";
        for(int i =0; i<26; i++){
            if((result&(1<<i))>0){
                res+=(char)(i+'A');
            }
        }
        return res;
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        menuList = new int[1<<26];
        List<String> menuArray = new ArrayList<>();
        int[] mx = new int[11];
        List<String> mxList[] = new ArrayList[11];
        for(int i=0; i<11; i++)
            mxList[i]=new ArrayList<>();
            for(String o : orders){
                dfs(o, 0, -1);
            }
        for(int i=0; i< (1<<26); i++){
            int cnt = menuList[i];
            if(cnt<2) continue;
            String str = getRes(i);
            int len = str.length();
            if(mx[len]<=cnt){
                if(mx[len]<cnt){
                    mx[len]=cnt;
                    mxList[len]= new ArrayList<>();
                }
                mxList[len].add(str);
            }
        }
        for(int c: course){
            if(mxList[c].isEmpty())continue;
            for(String s : mxList[c]){
                menuArray.add(s);
            }
        }
        int size = menuArray.size();
        answer = new String[size];
        Collections.sort(menuArray);
        for(int i=0; i<size; i++)
            answer[i]= menuArray.get(i);

        return answer;
    }
}
