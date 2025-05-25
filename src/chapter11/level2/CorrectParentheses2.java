package chapter11.level2;

/*
페이지 376
소괄호 개수 세기
 */
public class CorrectParentheses2 {
    public boolean solution(String s) {
        int counter = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> counter++;
                case ')' -> {
                    if (counter-- == 0) return false;
                }
            }
        }

        return counter == 0;
    }

    public static void main(String[] args) {
        CorrectParentheses2 c = new CorrectParentheses2();
        System.out.println(c.solution("()()"));
        System.out.println(c.solution("(())()"));
        System.out.println(c.solution(")()("));
        System.out.println(c.solution("(()("));
    }
}
