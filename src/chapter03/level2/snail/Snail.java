package chapter03.level2.snail;

import java.util.Arrays;/*
페이지 72
삼각 달팽이 - level2
진행과정
 */
public class Snail {
    public int[] solution(int n) {
        // 1. 달팽이 배열 만들기
        int[][] tri = new int[n][n];
        // 2차원 배열 tri 모두 0으로 채우기
        for (int i=0;i<tri.length;i++) {
            Arrays.fill(tri[i], 0);
        }

        // 숫자 채우기
        int num = 1; // 1부터 시작
        int x = 0; // 현재위치 행
        int y = 0; // 현재위치 열
        int row = n-1; // 행 경계 - 방향 전환을 위해
        int col = n-1; // 열 경계 - 방향 전환을 위해
        int s = 0; // 방향 스위치
        while(true) {
            if (0<=x && x<=n-1 && 0<=y && y<=n-1) {
                System.out.print(tri[x][y]+" ");
                // 다음으로 넘어간 tri 위치가 0 초과하면 모두 다 채운것
                if (tri[x][y] > 0) {

                    break;
                }

                if (s == 0 && x <= row) {
                    // 방향이 아래쪽
                    tri[x++][y] = num++;

                    if (x > row) {
                        s = 1; // 방향전환
                        row--; // 다음 차례 행 경계
                        x--; // 행의 경계를 넘었으니 -1 하기
                        y++; // 다음 열로 넘어가기
                    }
                } else if (s == 1 && y <= col) {
                    // 방향이 오른쪽
                    tri[x][y++] = num++;

                    if (y > col) {
                        s = 2; // 방향전환
                        col--; // 다음 차례 열 경계
                        y -= 2; // 열의 경계를 넘었으니 -2 하기
                        x--; // 대각선 위쪽에서 시작
                    }
                } else if (s == 2) {
                    // 방향이 대각선 위쪽
                    if (tri[x][y] != 0) {
                        s = 0; // 방향전환
                        x += 2; // 아래 두칸 아래로 이동
                        y++; // 한칸 오른쪽으로
                    } else if (tri[x][y] == 0) {
                        // 0이면 num + 1 추가
                        tri[x--][y--] = num++;
                    }
                }

                System.out.println(Arrays.deepToString(tri));
            }
        }

        //System.out.println(Arrays.deepToString(tri));

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        Snail snail = new Snail();
        System.out.println(Arrays.toString(snail.solution(4)));
//        System.out.println(Arrays.toString(snail.solution(5)));
//        System.out.println(Arrays.toString(snail.solution(6)));
    }
}
