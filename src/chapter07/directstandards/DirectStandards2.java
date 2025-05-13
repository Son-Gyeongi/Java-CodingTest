package chapter07.directstandards;

import java.util.Arrays;

/*
Comparator<T>를 이용하여 정렬하기
- 기본 정렬 기준이 사전 순인 문자열을 길이 순서대로 정렬
 */
public class DirectStandards2 {
    public static void main(String[] args) {
        String[] words = {"java", "algorithm", "programming", "happy", "fun", "coding"};
        Arrays.sort(words, (v1, v2) -> v1.length() - v2.length());
        // == Arrays.sort(words, Comparator.comparingInt(String::length));

        System.out.println(Arrays.toString(words));
    }
}
