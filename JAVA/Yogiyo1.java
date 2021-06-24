import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Yogiyo1 {
    public String solution(String S, String C) {
        String[] nameList = S.split(";");
        ArrayList<String> emails = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        C= C.toLowerCase();
        for(int i =0; i<nameList.length; i++){
            String email="";
            String name = nameList[i].trim();
            String[] sep = name.split(" ");
            String firstName = sep[0].toLowerCase();
            String lastName = sep[sep.length-1].replace("-","").toLowerCase();
            if(firstName.length()>8){
                firstName=firstName.substring(0, 8);
            }
            if(lastName.length()>8){
                lastName=lastName.substring(0, 8);
            }
            String id = firstName+"."+lastName;
            if(m.get(id)==null){
                m.put(id, 1);
            }else{
                int num = m.get(id);
                m.put(id,num+1);
                id+=num+1;
            }
            email = id+"@"+C+".com";
            emails.add(email);
        }


        int len = emails.size();
        String ans ="";
        for(int i =0; i<len; i++){
            if(i<len-1){
                ans+=emails.get(i)+"; ";
            }else{
                ans+=emails.get(i);
            }
        }
        return ans;
    }
}
