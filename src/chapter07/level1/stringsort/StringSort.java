package chapter07.level1.stringsort;

import java.util.Arrays;

public class StringSort {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });

        return strings;
    }

    public static void main(String[] args) {
        StringSort ss = new StringSort();
        String[] arr1 = {"sun", "bed", "car"};
        String[] arr2 = {"abce", "abcd", "cdx"};
        System.out.println(Arrays.toString(ss.solution(arr1, 1)));
        System.out.println(Arrays.toString(ss.solution(arr2, 2)));
    }
}
