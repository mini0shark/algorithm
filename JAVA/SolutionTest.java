public class SolutionTest {
    public static void main(String[] args) {
        Programmers72411 p = new Programmers72411();
        String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String [] st= p.solution(order, course);
        for(String s: st)
            System.out.println(s);
    }
}
