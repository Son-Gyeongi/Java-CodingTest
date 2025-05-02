package chapter04.level1.stringpy;

/*
페이지 137
 */
public class StringPYAnswer {
    boolean solution(String s) {
        s = s.toLowerCase();
        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        return ps == ys;
    }

    public static void main(String[] args) {
        StringPYAnswer str = new StringPYAnswer();
        System.out.println(str.solution("pPoooyY"));
        System.out.println(str.solution("PyY"));
    }
}
