package chapter04.level1.stringpy;

/*
페이지 137
 */
public class StringPYAnswer2 {
    boolean solution(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p','P'-> ps++;
                case 'y','Y'-> ys++;
            }
        }

        return ps == ys;
    }

    public static void main(String[] args) {
        StringPYAnswer2 str = new StringPYAnswer2();
        System.out.println(str.solution("pPoooyY"));
        System.out.println(str.solution("PyY"));
    }
}
