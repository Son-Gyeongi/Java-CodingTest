package chapter11.level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
페이지 441
Deque (덱)을 활용한 풀이
 */
public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i=0;i<operations.length;i++) {
            String[] arr = operations[i].split(" ");
            String command = arr[0];
            int num = Integer.parseInt(arr[1]);

            if (command.equals("I")) {
                if (dq.size() == 0) {
                    dq.add(num);
                    continue;
                }

                int first = dq.peekFirst();
                int last = dq.peekLast();

                // 오름차순 정렬
                if (num <= first) {
                    dq.offerFirst(num);
                } else {
                    dq.offerLast(num);
                }
            } else {
                if (num == -1) {
                    // 최솟값 제거
                    if (dq.size() != 0) {
                        dq.pollFirst();
                    }
                } else {
                    // 최댓값 제거, num == 1
                    if (dq.size() != 0) {
                        dq.pollLast();
                    }
                }
            }
        }

        int[] answer = {0,0};
        if (dq.size() != 0) {
            answer[0] = dq.pollLast();
            answer[1] = dq.pollFirst();
        }
        return answer;
    }

    public static void main(String[] args) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        String[] arr1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] arr2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(dpq.solution(arr1)));
        System.out.println(Arrays.toString(dpq.solution(arr2)));
    }
}
