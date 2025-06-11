package chapter13.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
페이지 558
 */
public class ParkingFeeCalAnswer {
    private static class Fee {
        private final int baseTime;
        private final int baseFee;
        private final int unitTime;
        private final int unitFee;

        public Fee(int baseTime, int baseFee, int unitTime, int unitFee) {
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }

        public int cost(int time) {
            int fee = baseFee;
            time -= baseTime;

            while (time > 0) {
                fee += unitFee;
                time -= unitTime;
            }

            return fee;
        }
    }

    private static class Car {
        public final String number;
        private final Fee fee;
        private int inTime = -1;
        private int totalTime = 0;

        public Car(String number, Fee fee) {
            this.number = number;
            this.fee = fee;
        }

        public void in(int time) {
            this.inTime = time;
        }

        public void out(int time) {
            if (this.inTime == -1) return;
            totalTime += time - this.inTime;
            this.inTime = -1;
        }

        public int cost() {
            return fee.cost(totalTime);
        }
    }

    private int parseTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }

    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);

        Map<String, Car> cars = new HashMap<>();
        for (String record : records) {
            String[] tokens = record.split(" ");
            int time = parseTime(tokens[0]);
            String number = tokens[1];
            boolean isIn = tokens[2].equals("IN");

            if (!cars.containsKey(number)) {
                cars.put(number, new Car(number, fee));
            }

            Car car = cars.get(number);
            if (isIn) {
                car.in(time);
            } else {
                car.out(time);
            }
        }

        int endTime = parseTime("23:59");
        for (Car car : cars.values()) {
            car.out(endTime);
        }

        return cars.values().stream()
                .sorted(Comparator.comparing(car -> car.number))
                .mapToInt(Car::cost)
                .toArray();
    }

    public static void main(String[] args) {
        ParkingFeeCalAnswer p = new ParkingFeeCalAnswer();
        int[] fees1 = {180, 5000, 10, 600};
        int[] fees2 = {120, 0, 60, 591};
        int[] fees3 = {1, 461, 1, 10};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        String[] records3 = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(p.solution(fees1, records1)));
        System.out.println(Arrays.toString(p.solution(fees2, records2)));
        System.out.println(Arrays.toString(p.solution(fees3, records3)));
    }
}
