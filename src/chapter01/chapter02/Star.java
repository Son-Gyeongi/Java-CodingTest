package chapter01.chapter02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Star {
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<Integer[]> set = new TreeSet<>(); // 중복 제거, 오름차순 정렬

        /*
        1. line 배열 이중 for문으로 교차점 계산
        2. 소수점 있는 x,y는 배제
        3. 정수 좌표 Set에 저장 (중복 제거)
        */
        for (int i=0;i<line.length;i++) {
            for (int j=i+1;j<line.length;j++) {
                float d = line[i][0]*line[j][1] - line[i][1]*line[j][0];
                if (d == 0) continue; // 평행 또는 일치
                float x1 = (line[i][1]*line[j][2] - line[i][2]*line[j][1]) / d;
                float y1 = (line[i][2]*line[j][0] - line[i][0]*line[j][2]) / d;

                int x2 = (line[i][1]*line[j][2] - line[i][2]*line[j][1]) / (int)d;
                int y2 = (line[i][2]*line[j][0] - line[i][0]*line[j][2]) / (int)d;

                if (x1 == x2 && y1 == y2) {
                    set.add(new Integer[]{x2,y2});
                }
            }
        }

        Iterator<Integer[]> it = set.iterator();
        while(it.hasNext()) {
            Integer[] i = it.next();
            System.out.println(Arrays.toString(i));
        }

        return answer;
    }
}
