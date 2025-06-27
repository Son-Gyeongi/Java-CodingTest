package chapter14.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
페이지 644
PCCP 모의고사 2회
신입사원 교육 - Level2
 */
public class NewEmployeeAnswer {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = Arrays.stream(ability)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        int[] ability1 = {10, 3, 7, 2};
        int[] ability2 = {1, 2, 3, 4};
        NewEmployeeAnswer newEmployee = new NewEmployeeAnswer();
        System.out.println(newEmployee.solution(ability1, 2));
        System.out.println(newEmployee.solution(ability2, 3));
    }
}
