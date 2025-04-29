package chapter03.distance;

import java.util.Arrays;

public class DistanceAnswer {
    private static final int dx[] = {0, -1, 1, 0}; // 상좌우하
    private static final int dy[] = {-1, 0, 0, 1}; // 상좌우하

    // 1-B. 빈 테이블과 인접한 위치 중 응시자가 있다면 거리두기를 지키지 않은 것
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }

        return false;
    }

    // room[y][x]가 거리두기를 지키는지 검사
    private boolean isDistanced(char[][] room, int x, int y) {
        // 1-A. 상하좌우 중 빈 테이블이 있는 방향에 대해 1-B로 진행
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // room[ny][nx]를 통해 다른 응시자에게 도달할 수 있는지 검사
            switch (room[ny][nx]) {
                case 'P' : return false;
                case 'O' :
                    // 인접한 곳에 다른 응시자가 있는지 검사
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }

    // 거리두기 검사
    private boolean isDistanced(char[][] room) {
        // 1. 대기실의 모든 응시자 위치에 대해 반복
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DistanceAnswer dis = new DistanceAnswer();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(dis.solution(places)));
    }
}
