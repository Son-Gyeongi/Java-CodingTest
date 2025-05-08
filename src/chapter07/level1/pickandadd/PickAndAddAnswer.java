package chapter07.level1.pickandadd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickAndAddAnswer {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        PickAndAddAnswer pick = new PickAndAddAnswer();
        int[] numbers1 = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};
        System.out.println(Arrays.toString(pick.solution(numbers1)));
        System.out.println(Arrays.toString(pick.solution(numbers2)));
    }
}
