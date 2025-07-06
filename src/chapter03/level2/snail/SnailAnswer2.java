package chapter03.level2.snail;

import java.util.Arrays;

/*
페이지 72
삼각 달팽이 - level2
dx,dy로 방향을 정하는 방법
 */
public class SnailAnswer2 {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SnailAnswer2 snail = new SnailAnswer2();
        System.out.println(Arrays.toString(snail.solution(4)));
        System.out.println(Arrays.toString(snail.solution(5)));
        System.out.println(Arrays.toString(snail.solution(6)));
    }
}
