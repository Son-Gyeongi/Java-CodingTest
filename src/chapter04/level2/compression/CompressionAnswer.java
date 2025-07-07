package chapter04.level2.compression;

import java.util.ArrayList;
import java.util.List;

/*
페이지 120
lv.2 문자열 압축
문제 풀이
 */
public class CompressionAnswer {
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) {
                endIndex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    builder.append(count);
                }
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            builder.append(count);
        }
        builder.append(last);

        return builder.length();
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length < s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        CompressionAnswer c = new CompressionAnswer();
        System.out.println(c.solution("aabbaccc"));
        System.out.println(c.solution("ababcdcdababcdcd"));
        System.out.println(c.solution("abcabcdede"));
        System.out.println(c.solution("abcabcabcabcdededededede"));
        System.out.println(c.solution("xababcdcdababcdcd"));
    }
}
