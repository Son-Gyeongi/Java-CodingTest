package chapter03.level2.snail;

import java.util.Arrays;

/*
페이지 72
삼각 달팽이 - level2
내 정답
 */
public class Snail {
    public int[] solution(int n) {
        // 1. 달팽이 배열 만들기
        int[][] tri = new int[n][n];
        int s=0; // 스위치(방향 전환)
        int x=0; // 행
        int y=0; // 열
        int num=1; // 숫자
        int count = n;

        for (int i=count;i>0;i--) {
            if (s%3==0) {
                // 아래쪽 이동
                for (int j=0;j<i;j++) {
                    // x++, y그대로
                    tri[x++][y] = num++;
                }
                // 다음칸 이동
                x--;
                y++;
            } else if (s%3==1) {
                // 오른쪽 이동
                for (int j=0;j<i;j++) {
                    // x그대로, y++
                    tri[x][y++] = num++;
                }
                // 다음칸 이동
                y-=2;
                x--;
            } else if (s%3==2) {
                // 오른쪽 위 대각선 이동
                for (int j=0;j<i;j++) {
                    // x--, y--
                    tri[x--][y--] = num++;
                }
                // 다음칸 이동
                x+=2;
                y++;
            }
            s++;
        }

        // 2. 달팽이 배열에서 0행부터 n행까지 순차적으로 가져오기
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<=i;j++) {
                answer[idx++] = tri[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Snail snailIng = new Snail();
        System.out.println(Arrays.toString(snailIng.solution(4)));
        System.out.println(Arrays.toString(snailIng.solution(5)));
        System.out.println(Arrays.toString(snailIng.solution(6)));
    }
}
