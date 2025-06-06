package chapter12.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
페이지 523
2차원 배열에서 최단 거리나 최단 시간을 찾는 것 - BFS
상태의 전이와 큐를 이용하여 BFS 구현
 */
public class GameMapShortAnswer {
    /*
    1. 상태 정의
    - 2차원 좌표 x,y
    - BFS를 위한 step 변수까지 포함
     */
    private static class State {
        public final int x;
        public final int y;
        public final int step;

        public State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    /*
    - 상태는 2차원 지도에서 상하좌우로 진행
     */
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        /*
        2. 방문 검사 배열
        2차원 배열에서 각 좌표의 방문 상태를 나타내는 isVisited를 게임 맵의 크기에 맞게 선언
         */
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];

        /*
        3. 초기 상태
        - BFS를 위해 큐를 선언하고, 초기 상태를 넣어준다.
        - 상태가 전이되면서 진행되는 칸 개수를 세야 한다.
        - 초기 상태는 한 칸으로 시작하기 때문에 step 변수는 1이 된다.
        - 초기 상태에 대한 중복 처리도 함께한다.
         */
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));
        isVisited[0][0] = true;

        /*
        4. 탐색 진행
        - 모든 탐색 공간을 순회한다.
         */
        while (!queue.isEmpty()) {
            State state = queue.poll();

            /*
            5. 현재 상태 처리
            - 상태에 대한 정답 처리
            - 좌표가 게임 맵의 오른쪽 아래에 도달하는 것이 목표 상태
            - 목표 상태에 도달했는지 검사, 도달했다면 초기 상태부터 세어 준 step을 반환
             */
            if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
                return state.step;
            }

            /*
            6. 전이 상태 생성
            - 상태 전이는 dx, dy를 이용한 방향에 따른 좌표 변환
             */
            for (int d = 0; d < 4; d++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                /*
                7. 범위 검사
                - 변환된 nx와 ny 좌표가 게임 맵의 범위에 들어오는지 검사
                 */
                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
                    continue;
                }

                /*
                8. 유효성 검사
                - 게임 맵 안에서 nx, ny가 벽이 없는 좌표인지 검사
                 */
                if (maps[ny][nx] != 1) {
                    continue;
                }

                /*
                9. 중복 검사
                - 이전에 방문한 적이 있는 좌표 검사
                 */
                if (isVisited[ny][nx]) {
                    continue;
                }

                /*
                10. 방문 처리 & 상태 전이
                - 모든 검사를 통과했다면 전이 가능한 상태
                - 방문 처리를 하고, step 변수값을 증가시켜 탐색 공간에 추가
                 */
                isVisited[ny][nx] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }
        }

        /*
        모든 탐색 공간을 탐색했는데 목표 상태를 발견하지 못했다면 목표 상태로 도달할 수 없는 경우,
        즉 캐릭터가 상대 팀 진영에 도달할 수 없는 경우
         */
        return -1;
    }

    public static void main(String[] args) {
        GameMapShortAnswer gm = new GameMapShortAnswer();
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(gm.solution(maps1));
        System.out.println(gm.solution(maps2));
    }
}
