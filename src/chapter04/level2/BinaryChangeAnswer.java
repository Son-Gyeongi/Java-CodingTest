package chapter04.level2;

import java.util.Arrays;

public class BinaryChangeAnswer {
    // 1-A. 문자열에 포함된 0의 개수 세기
    private int countZero(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }

    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        // s가 "1"이 될 때까지 반복하며 loop, removed 누적
        while (!s.equals("1")) {
            // 1-A-i. 0의 개수와 제거 횟수 누적
            int zeros = countZero(s);
            loop += 1;
            removed += zeros;

            // 문자열 s 변환
            // 1-B. 나머지 1의 개수를 사용해서 2진법으로 변환하여 1부터 반복
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[]{loop, removed};
    }

    public static void main(String[] args) {
        BinaryChangeAnswer binary = new BinaryChangeAnswer();
        System.out.println(Arrays.toString(binary.solution("110010101001")));
    }
}
