package chapter07.level2.biggest;

import java.util.*;

/*
페이지 257
 */
public class Biggest {
    public static Set<String> set = new HashSet<>();
//    public static List<String> list = new ArrayList<>();
    public static int count = 0;

    public void combination(String str, String[] arr, boolean[] used) {
        if (str.length() == count) {
            set.add(str);
            return;
        }

        for (int i=0;i<arr.length;i++) {
            if (!used[i]) {
                used[i] = true;
                combination(str+arr[i], arr, used);
                used[i] = false;
            }
        }
    }

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        count = 0;
        for (int i=0;i<numbers.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
            count += arr[i].length();
        }

        Arrays.sort(arr, Collections.reverseOrder());
        combination("", arr, new boolean[arr.length]);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        return list.get(0);
    }

    public static void main(String[] args) {
        Biggest biggest = new Biggest();
        int[] arr1 = {6, 10, 2};
        int[] arr2 = {3, 30, 34, 5, 9};
        System.out.println(biggest.solution(arr1));
        System.out.println(biggest.solution(arr2));
    }
}
