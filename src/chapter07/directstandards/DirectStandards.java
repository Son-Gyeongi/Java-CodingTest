package chapter07.directstandards;

import java.util.Arrays;

/*
Comparator<T>를 이용하여 정렬하기
- 배열 내림차순 정렬
 */
public class DirectStandards {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 4, 7, 4, 0, 9};
        int[] reversed = Arrays.stream(arr)
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(reversed));
    }
}
