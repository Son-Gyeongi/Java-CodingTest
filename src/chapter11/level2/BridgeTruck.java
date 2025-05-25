package chapter11.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
페이지 395
 */
public class BridgeTruck {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truckWeights.length) {
            bridgeWeight -= bridge.poll();

            int truckWeight = truckWeights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        BridgeTruck t = new BridgeTruck();
        int[] truckWeights1 = {7, 4, 5, 6};
        int[] truckWeights2 = {10};
        int[] truckWeights3 = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(t.solution(2, 10, truckWeights1));
        System.out.println(t.solution(100, 100, truckWeights2));
        System.out.println(t.solution(100, 100, truckWeights3));
    }
}
