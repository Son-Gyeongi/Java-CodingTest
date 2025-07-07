package chapter04.level2.compression;

import java.util.Stack;

/*
페이지 120
lv.2 문자열 압축
나의 문제 풀이
 */
public class Compression {
    public int solution(String s) {
        if (s.length() == 1) return 1;

        StringBuilder pattern = new StringBuilder();
        int min = Integer.MAX_VALUE;

        for (int i=0;i<(s.length()/2);i++) {
            pattern.append(s.charAt(i));
            String standard = pattern.toString();
            Stack<String> stack = new Stack<>();

            StringBuilder tmpSb = new StringBuilder(); // 문자열 완성본
            int unit = pattern.length(); // 문자 개수 단위
            for (int x=0;x<s.length();x+=unit) {
                String comStr=""; // 비교 문자열
                if ((x+unit) >= s.length()) {
                    comStr += s.substring(x);
                } else {
                    comStr += s.substring(x, x+unit);
                }

                if (standard.equals(comStr)) {
                    stack.push(comStr);
                } else if (!stack.isEmpty()) { // stack.size() != 0
                    int size = stack.size();
                    if (size > 1) tmpSb.append(size).append(stack.peek());
                    else tmpSb.append(stack.peek());
                    standard = comStr;
                    stack.clear();
                    stack.push(comStr);
                }
            }

            if (!stack.isEmpty()) {
                // 마지막 스택이 비어있지 않다면
                if (stack.size() > 1) tmpSb.append(stack.size()).append(stack.peek());
                else tmpSb.append(stack.peek());
            }

            // tmpSb 에서 "1" 제거하기 - 1을 제거하니 10이 제거되네
            String str = tmpSb.toString();
            // 길이 재고 최소값 찾기
            min = Math.min(min, str.length());
        }

        return min;
    }

    public static void main(String[] args) {
        Compression c = new Compression();
        System.out.println(c.solution("aabbaccc"));
        System.out.println(c.solution("ababcdcdababcdcd"));
        System.out.println(c.solution("abcabcdede"));
        System.out.println(c.solution("abcabcabcabcdededededede"));
        System.out.println(c.solution("xababcdcdababcdcd"));
    }
}
