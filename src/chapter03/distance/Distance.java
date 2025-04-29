package chapter03.distance;

import java.util.Arrays;

public class Distance {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};

        /*
        1. places 배열에서 각 요소들의 가로 먼저 검사(PP, POP 인 경우 0)
        2. 1에서 0이 아닌 경우만 places 배열 각 요소들을 2차원 배열에 넣기 (세로, 대각선 PP, POP 인 경우 검사)
            ㄱ. 세로는 String에 넣어서 contains() 로 검사
            ㄴ. 2차원 배열에서 O을 기준으로 상하좌우에 P가 2개 이상이면 0

        예외 - 응시자가 없는 경우 (P가 없는 경우 또는 1개 있는 경우)
        */
        for (int i=0;i<places.length;i++) {
            for (int j=0;j<places[i].length;j++) {
                if (places[i][j].contains("PP") || places[i][j].contains("POP")) answer[i] = 0;
            }
        }

        for (int i=0;i<answer.length;i++) {
            if (answer[i] == 0) continue;

            String[] str = places[i];

            // 2차원 배열에 저장
            String[][] strArr = new String[str.length][str[0].length()];
            for (int j=0;j<strArr.length;j++) {
                for (int k=0;k<strArr[j].length;k++) {
                    strArr[j][k] = ""+str[j].charAt(k);
                }
            }

            // 세로 검사
            String[] s = new String[strArr.length];
            Arrays.fill(s, "");
            for (int j=0;j<strArr.length;j++) {
                for (int k=0;k<strArr[j].length;k++) {
                    s[k] += strArr[j][k];
                }
            }

            for (int j=0;j<s.length;j++) {
                if (s[j].contains("PP") || s[j].contains("POP")) answer[i] = 0;
            }

            int[] dx = {-1,1,0,0}; // 상하좌우
            int[] dy = {0,0,-1,1}; // 상하좌우
            // strArr 2차원 배열에서 상하좌우 검사
            outer:
            for (int x=0;x<strArr.length;x++) {
                for (int y=0;y<strArr[x].length;y++) {
                    int count = 0;

                    for (int z=0;z<dx.length;z++) {
                        int px = x+dx[z];
                        int py = y+dy[z];

                        if (0<=px && px<strArr.length && 0<=py && py<strArr[0].length) {
                            if(strArr[x][y].equals("O") && strArr[px][py].equals("P")) count++;
                        }
                    }

                    if (count >= 2) {
                        answer[i] = 0;
                        break outer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Distance dis = new Distance();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(dis.solution(places)));
    }
}
