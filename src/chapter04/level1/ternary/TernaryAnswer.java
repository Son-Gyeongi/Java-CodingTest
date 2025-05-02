package chapter04.level1.ternary;

public class TernaryAnswer {
    public int solution(int n) {
        /*
        1. 정수를 3진법으로 변환
        2. 변환된 문자열 뒤집기
        3. 뒤집은 문자열을 정수로 변환
         */
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }

    public static void main(String[] args) {
        TernaryAnswer ternary = new TernaryAnswer();
        System.out.println(ternary.solution(100000000));
    }
}
