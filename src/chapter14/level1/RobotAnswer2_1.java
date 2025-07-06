package chapter14.level1;

import java.util.Arrays;

/*
페이지 640
PCCP 모의고사 2회
실습용 로봇 - Level1
 */
public class RobotAnswer2_1 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[] solution(String command) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (char c : command.toCharArray()) {
            switch (c) {
                case 'R' -> d = (d + 1) % 4;
                case 'L' -> d = (d + 3) % 4;
                case 'G' -> {
                    x += dx[d];
                    y += dy[d];
                }
                case 'B' -> {
                    x -= dx[d];
                    y -= dy[d];
                }
            }
        }

        return new int[] {x, y};
    }

    public static void main(String[] args) {
        RobotAnswer2_1 r = new RobotAnswer2_1();
        String command1 = "GRGLGRG";
        String command2 = "GRGRGRB";
        System.out.println(Arrays.toString(r.solution(command1)));
        System.out.println(Arrays.toString(r.solution(command2)));
    }
}
