package chapter06.level1.mockexam;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
페이지 192
 */
public class MockExamAnswer {
    private static final int[][] RULES = {
            {1,2,3,4,5}, // 5개
            {2,1,2,3,2,4,2,5}, // 8개
            {3,3,1,1,2,2,4,4,5,5} // 10개
    };

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            // 각 수포자별로 정답 개수 세기
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    corrects[person]++;
                    // max 업데이트하기
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }

    public static void main(String[] args) {
        MockExamAnswer me = new MockExamAnswer();
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(me.solution(answers1)));
        System.out.println(Arrays.toString(me.solution(answers2)));
    }
}
