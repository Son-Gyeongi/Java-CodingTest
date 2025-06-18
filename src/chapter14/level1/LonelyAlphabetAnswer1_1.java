package chapter14.level1;

/*
페이비 618
PCCP 모의고사 1회
외톨이 알파벳 - Level1
 */
public class LonelyAlphabetAnswer1_1 {
    public String solution(String input_string) {
        input_string = "." + input_string + ".";

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (input_string.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.isEmpty()) { // builder.length() == 0
            return "N";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LonelyAlphabetAnswer1_1 l = new LonelyAlphabetAnswer1_1();
        System.out.println(l.solution("edeaaabbccd"));
        System.out.println(l.solution("eeddee"));
        System.out.println(l.solution("string"));
        System.out.println(l.solution("zbzbz"));
    }
}
