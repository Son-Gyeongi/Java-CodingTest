package chapter07.level1.stringdesc;

import java.util.Arrays;

public class StringDesc {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.stream(strings)
                .sorted((s1, s2) -> s1.charAt(n) - s2.charAt(n))
                .toArray(String[]::new);

        return answer;
    }

    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        StringDesc sd = new StringDesc();
        System.out.println(sd.solution("Zbcdefg"));
    }
}
