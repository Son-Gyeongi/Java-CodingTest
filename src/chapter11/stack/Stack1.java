package chapter11.stack;

import java.util.Stack;

/*
페이지 374
 */
public class Stack1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.add(4);
        stack.add(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
