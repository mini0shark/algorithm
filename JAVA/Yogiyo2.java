public class Yogiyo2 {
    public String solution(String S) {
        int ans = 1000;
        S=S.trim();
        String[] list = S.split("\\n");

        for(String line : list){
            String[] lineSplit = line.split(" ");
            String owner = lineSplit[0].trim();
            String perm = lineSplit[1].trim();
            String name = lineSplit[2].trim();
            String[] splitByDot = name.split("\\.");
            String extension = splitByDot[splitByDot.length-1];

            if(owner.equals("root")){
                ans=Math.min(ans, name.length()); continue;
            }
            if(extension.equals("doc")|| extension.equals("xls") || extension.equals("pdf")){
                ans=Math.min(ans, name.length());
                continue;
            }
            if(perm.charAt(0)=='r' && perm.charAt(1)=='-'){
                ans=Math.min(ans, name.length());
                continue;
            }
        }
        

        String ansString = ans<1000?Integer.toString(ans):"NO FILES";
        return ansString;
    }
}
