package chapter12.level2;

import java.util.Stack;

/*
페이지 505
DFS(Depth First Search, 깊이 우선 탐색)
 */
public class TargetNumberAnswer {
    private static class State {
        public final int index; // 배열 인덱스 위치
        public final int acc; // 누적값

        public State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }

    public int solution(int[] numbers, int target) {
        // 초기 상태
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));

        // 현재 상태 처리
        int count = 0;

        // 탐색 진행 - 전체 탐색 공간의 탐색을 진행
        while (!s.isEmpty()) {
            State state = s.pop();

            // 현재 상태 처리
            if (state.index == numbers.length) {
                if (state.acc == target) count++;
                continue;
            }

            // 상태 전이
            // +를 선택한 경우
            s.push(new State(state.index + 1, state.acc + numbers[state.index]));
            // -를 선택한 경우
            s.push(new State(state.index + 1, state.acc - numbers[state.index]));
        }

        // DFS 를 이용하여 세어 준 경우의 수 반환
        return count;
    }

    public static void main(String[] args) {
        TargetNumberAnswer tn = new TargetNumberAnswer();
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};
        System.out.println(tn.solution(numbers1, 3));
        System.out.println(tn.solution(numbers2, 4));
    }
}
