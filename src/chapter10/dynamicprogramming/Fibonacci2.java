package chapter10.dynamicprogramming;

/*
페이지 339
 */
public class Fibonacci2 {
    private static int calls = 0;

    private static long fibonacci(int n) {
        calls++;
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println("호출 수: " + calls);
    }
}
