package chapter05.recursive;

public class Recursive {
    private int power(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 1;
        if (n == 0) return 1;

        // 점화식 구현하기
        return n * power(n, m - 1);
    }

    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        System.out.println(recursive.power(2, 5));
    }
}
