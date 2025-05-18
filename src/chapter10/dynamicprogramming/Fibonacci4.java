package chapter10.dynamicprogramming;

import java.util.Arrays;

/*
페이지 347
순차 누적
 */
public class Fibonacci4 {
    private static long iterativeFibonacci(int n) {
        long[] mem = new long[n + 1];
        mem[0] = 0;
        mem[1] = 1;

        for (int i = 0; i <= n - 1; i++) {
            mem[i + 1] += mem[i];
            if (i + 2 < mem.length) mem[i + 2] += mem[i];
        }

        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(iterativeFibonacci(10));
    }
}
