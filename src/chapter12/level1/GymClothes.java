package chapter12.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
페이지 533
그리디 알고리즘
 */
public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve) // 교집합
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        for (int l : lost) q.add(l);

        int get = 0;
        for (int r : reserve) {
            if (owns.contains(r)) {
                continue;
            }

            while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }
            if (q.isEmpty()) break;

            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get;
    }

    public static void main(String[] args) {
        GymClothes g = new GymClothes();
        int[] lost1 = {2, 4};
        int[] lost2 = {2, 4};
        int[] lost3 = {3};
        int[] reserve1 = {1, 3, 5};
        int[] reserve2 = {3};
        int[] reserve3 = {1};
        System.out.println(g.solution(5, lost1, reserve1));
        System.out.println(g.solution(5, lost2, reserve2));
        System.out.println(g.solution(3, lost3, reserve3));
    }
}
