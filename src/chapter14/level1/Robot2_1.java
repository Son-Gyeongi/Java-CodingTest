package chapter14.level1;

import java.util.Arrays;

/*
페이지 640
PCCP 모의고사 2회
실습용 로봇 - Level1
내가 작성한 로직
 */
public class Robot2_1 {
    public int[] solution(String command) {
        int[] answer = {0,0};
        boolean xy = true; // y축 true, x축 false
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 위쪽,오른쪽,아래쪽,왼쪽 방향
        int index = 0; // 위쪽 방향으로 시작

        for (int i=0;i<command.length();i++) {
            char c = command.charAt(i);

            if (c == 'R') {
                // 오른쪽 90도 회전
                index++;
            } else if (c == 'L') {
                // 왼쪽 90도 회전
                index--;
            } else if (c == 'G') {
                // 전진
                answer[0] += dir[index][0];
                answer[1] += dir[index][1];
            } else if (c == 'B') {
                // 후진
                answer[0] -= dir[index][0];
                answer[1] -= dir[index][1];
            }

            if (index < 0) index += 4;
            if (index > 3) index %= 4;
        }

        return answer;
    }

    public static void main(String[] args) {
        Robot2_1 r = new Robot2_1();
        String command1 = "GRGLGRG";
        String command2 = "GRGRGRB";
        System.out.println(Arrays.toString(r.solution(command1)));
        System.out.println(Arrays.toString(r.solution(command2)));
    }
}
