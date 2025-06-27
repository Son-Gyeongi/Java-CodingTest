package chapter14.level2;

import java.util.Arrays;

/*
페이지 644
PCCP 모의고사 2회
신입사원 교육 - Level2
 */
public class NewEmployee {
    public int solution(int[] ability, int number) {
        int count = 0;
        while (count < number) {
            Arrays.sort(ability);
            int tmp = ability[0] + ability[1];
            ability[0] = tmp;
            ability[1] = tmp;
            count++;
        }

        int answer = 0;
        for (int i=0;i<ability.length;i++) {
            answer += ability[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ability1 = {10, 3, 7, 2};
        int[] ability2 = {1, 2, 3, 4};
        NewEmployee newEmployee = new NewEmployee();
        System.out.println(newEmployee.solution(ability1, 2));
        System.out.println(newEmployee.solution(ability2, 3));
    }
}
