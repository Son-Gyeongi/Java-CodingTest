package chapter07.level1.kthnumber;

import java.util.Arrays;

public class KThNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1; // 시작 위치
            int to = command[1]; // 끝 위치
            int k = command[2] - 1; // 정렬 후 위치

            // 부분 배열
            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub); // 기본 정렬 기준 오름차순
            answer[i] = sub[k];
        }

        return answer;
    }

    public static void main(String[] args) {
        KThNumber k = new KThNumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(k.solution(array, commands)));

    }
}
