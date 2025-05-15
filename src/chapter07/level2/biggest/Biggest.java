package chapter07.level2.biggest;

import java.util.*;

/*
페이지 257
 */
public class Biggest {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        String[] temp = new String[numbers.length];

        for (int i=0;i<arr.length-1;i++) {
            String str1 = arr[i]+arr[i+1];
            String str2 = arr[i+1]+arr[i];

            if (Integer.parseInt(str1) > Integer.parseInt(str2)) {
                temp[i] = arr[i];
                temp[i+1] = arr[i+1];
            } else {
                temp[i] = arr[i+1];
                temp[i+1] = arr[i];
            }
        }

        String answer = "";
        for (int i=0;i<temp.length;i++) {
            answer += temp[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Biggest biggest = new Biggest();
        int[] arr1 = {6, 10, 2};
        int[] arr2 = {3, 30, 34, 5, 9};
        System.out.println(biggest.solution(arr1));
        System.out.println(biggest.solution(arr2));
    }
}
