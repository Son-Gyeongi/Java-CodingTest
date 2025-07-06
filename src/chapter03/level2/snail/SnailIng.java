package chapter03.level2.snail;

import java.util.Arrays;

/*
페이지 72
삼각 달팽이 - level2
진행과정 2
 */
public class SnailIng {
    public int[] solution(int n) {
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
        System.out.println(Arrays.deepToString(tri));
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        SnailIng snailIng = new SnailIng();
        System.out.println(Arrays.toString(snailIng.solution(4)));
//        System.out.println(Arrays.toString(snail.solution(5)));
//        System.out.println(Arrays.toString(snail.solution(6)));
    }
}
