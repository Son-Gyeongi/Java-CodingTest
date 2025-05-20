package chapter11.level2;

import java.util.Stack;

/*
페이지 376
닫는 괄호를 검사할 때 스택에서 짝이 되는 여는 괄호의 인덱스 알 수 있다.
 */
public class CorrectParentheses3 {
    private void findPair(char[] str) {
        System.out.println(str);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case '(' -> stack.push(i);
                case ')' -> {
                    if (stack.isEmpty()) return;

                    // 짝이 되는 괄호의 인덱스 출력
                    System.out.println(stack.pop() + ", " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        CorrectParentheses3 c = new CorrectParentheses3();
        c.findPair("()()".toCharArray());
        System.out.println();
        c.findPair("(())()".toCharArray());
        System.out.println();
        c.findPair(")()(".toCharArray());
        System.out.println();
        c.findPair("(()(".toCharArray());
    }
}
