package chapter03.star;

import java.util.*;

/*
진행 과정
 */
public class Star {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Long[]> list = new ArrayList<>();

        /*
        1. line 배열 이중 for문으로 교차점 계산
        2. 소수점 있는 x,y는 배제
        3. 정수 좌표 List에 저장
        */
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (int i=0;i<line.length;i++) {
            for (int j=i+1;j<line.length;j++) {
                double d = line[i][0]*line[j][1] - line[i][1]*line[j][0];
                if (d == 0) continue; // 평행 또는 일치
                double x1 = ((long)line[i][1]*line[j][2] - (long)line[i][2]*line[j][1]) / d;
                double y1 = ((long)line[i][2]*line[j][0] - (long)line[i][0]*line[j][2]) / d;

                long x2 = ((long)line[i][1]*line[j][2] - (long)line[i][2]*line[j][1]) / (long)d;
                long y2 = ((long)line[i][2]*line[j][0] - (long)line[i][0]*line[j][2]) / (long)d;

                if (x1 == x2 && y1 == y2) {
                    list.add(new Long[]{x2,y2});
                    minX = Math.min(minX, x2);
                    minY = Math.min(minY, y2);
                }
            }
        }

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        // 좌표 시작을 0,0을 맞추기 위해
        for (int i=0;i<list.size();i++) {
            list.get(i)[0] -= minX;
            list.get(i)[1] -= minY;

            maxX = Math.max(maxX, list.get(i)[0]);
            maxY = Math.max(maxY, list.get(i)[1]);
        }

        String[][] point = new String[(int)maxX+1][(int)maxY+1];

        for (int i=0;i<point.length;i++) {
            Arrays.fill(point[i],".");
        }

        for (int i=0;i<list.size();i++) {
            int x = (int)((long)list.get(i)[0]);
            int y = (int)((long)list.get(i)[1]);
            point[x][y] = "*";
        }

        answer = new String[(int)maxY+1];
        Arrays.fill(answer,"");

        for(int i=0;i<point.length;i++) {
            int index = answer.length-1;

            for (int j=0;j<point[i].length;j++, index--) {
                if (index < 0) {
                    break;
                }
                answer[index] += point[i][j];
            }
        }

        return answer;
    }
}
