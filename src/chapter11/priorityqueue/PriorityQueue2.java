package chapter11.priorityqueue;

import java.util.PriorityQueue;

/*
페이지 440
Comparator 비교 직접 작성 - 내림차순
 */
public class PriorityQueue2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.add(4);
        pq.add(2);
        pq.add(6);
        pq.add(1);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
