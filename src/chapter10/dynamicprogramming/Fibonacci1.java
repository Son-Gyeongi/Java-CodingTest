package chapter10.dynamicprogramming;

/*
페이지 338
 */
public class Fibonacci1 {
    private static long fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
