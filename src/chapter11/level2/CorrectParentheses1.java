package chapter11.level2;

import java.util.Stack;

/*
페이지 376
스택
 */
public class CorrectParentheses1 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CorrectParentheses1 c = new CorrectParentheses1();
        System.out.println(c.solution("()()"));
        System.out.println(c.solution("(())()"));
        System.out.println(c.solution(")()("));
        System.out.println(c.solution("(()("));
    }
}
