package chapter12.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
페이지 494
문제에 단계별로 접근
 */
public class PressTheKeypadAnswer {
    private static class Hand {
        private final int baseX;
        public final String hand;
        public final float preference;
        private int x;
        private int y;

        public Hand(String hand, boolean isPreferred, int x) {
            this.baseX = x; // 해당 손만 담당하는 키패드 위치
            this.hand = hand; // 어느 쪽 손인지
            this.preference = isPreferred ? 0.5f : 0; // 거리가 같은 경우 주사용 손은 거리-0.5 한다.
            this.x = x; // 처음 손가락 위치 0, 2
            this.y = 3; // 처음 손가락 위치 [3,0], [3,2]
        }

        // 거리구하기 - x와 y 좌표를 사용하여 구한 값에서 preference 값 빼기
        public float distance(int x, int y) {
            if (x == baseX) return 0; // 처음 *, # 에서 이동하지 않았다. 거리 0 이동
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - preference;
        }

        // 엄지 손가락 움직이기 - 실제로 엄지 손가락 위치를 이동
        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 계산한 거리에 따라 어느 손가락을 사용할지 정하기
    // 해당 손 위치를 번호 위치로 옮겨 준다.
    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = right;
        if (lDistance < rDistance) {
            hand = left;
        }
        hand.move(x, y);
        return hand;
    }

    // [y,x] 좌표 - 숫자를 키패드상의 위치로 변환
    private int getX(int number) {
        if (number == 0) return 1;
        return (number - 1) % 3;
    }

    private int getY(int number) {
        if (number == 0) return 3;
        return (number - 1) / 3;
    }

    public String solution(int[] numbers, String hand) {
        // 오른손과 왼손을 정의
        Hand right = new Hand("R", hand.equals("right"), 2); // [3,2]
        Hand left = new Hand("L", hand.equals("left"), 0); // [3,0]

        // 입력되는 숫자를 순서대로 처리하기 위해
        return Arrays.stream(numbers)
                .mapToObj(n -> press(n, right, left).hand) // press()로 해당 번호를 누르고, 누른 손의 문자로 변환
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        PressTheKeypadAnswer pressTheKeypadAnswer = new PressTheKeypadAnswer();
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(pressTheKeypadAnswer.solution(numbers1, "right"));
        System.out.println(pressTheKeypadAnswer.solution(numbers2, "left"));
        System.out.println(pressTheKeypadAnswer.solution(numbers3, "right"));
    }
}
