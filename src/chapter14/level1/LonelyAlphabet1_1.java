package chapter14.level1;

import java.util.Map;
import java.util.TreeMap;

/*
페이비 618
PCCP 모의고사 1회
외톨이 알파벳 - Level1
내가 작성한 로직
 */
public class LonelyAlphabet1_1 {
    public String solution(String input_string) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i=0;i<input_string.length();i++) {
            Character c = input_string.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c,0);
            }

            map.put(c, map.get(c)+1);
        }

        String answer = "";
        for (Character c : map.keySet()) {
            int pos = 0; // input_string 인덱스 위치
            int tmp = input_string.indexOf(c,pos); // 이전 값 저장

            while (true) {
                pos = input_string.indexOf(c,pos);
                if (pos-tmp >= 2) {
                    answer += c;
                    break;
                }
                if (pos == -1) break;
                tmp = pos;
                pos++;
            }
        }

        return answer.equals("") ? "N" : answer;
    }

    public static void main(String[] args) {
        LonelyAlphabet1_1 l = new LonelyAlphabet1_1();
        System.out.println(l.solution("edeaaabbccd"));
        System.out.println(l.solution("eeddee"));
        System.out.println(l.solution("string"));
        System.out.println(l.solution("zbzbz"));
    }
}
