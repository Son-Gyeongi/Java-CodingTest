package chapter11.priorityqueue;

import java.util.PriorityQueue;

/*
페이지 439
 */
public class PriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

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
