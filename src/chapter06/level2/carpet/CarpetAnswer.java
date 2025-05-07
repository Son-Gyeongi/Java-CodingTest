package chapter06.level2.carpet;

import java.util.Arrays;

public class CarpetAnswer {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            // width 가로, height 세로
            for (int height = 3; height <= width; height++) {
                // 조건 검사
                int boundary = (width + height - 2) * 2; // 경계 격자 개수
                int center = width * height - boundary; // 내부 격자 개수

                if (brown == boundary && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        CarpetAnswer carpet = new CarpetAnswer();
        System.out.println(Arrays.toString(carpet.solution(10, 2)));
        System.out.println(Arrays.toString(carpet.solution(8, 1)));
        System.out.println(Arrays.toString(carpet.solution(24, 24)));
    }
}
