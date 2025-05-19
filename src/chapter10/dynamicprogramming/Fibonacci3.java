package chapter10.dynamicprogramming;

import java.util.Arrays;

/*
페이지 343
동적 프로그래밍 - 메모제이션
 */
public class Fibonacci3 {
    private static int calls = 0;
    private static final long[] mem = new long[101];

    private static long fibonacci(int n) {
        calls++;
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Arrays.fill(mem, -1);
        System.out.println(fibonacci(10));
        System.out.println("호출 수: " + calls);
    }
}
