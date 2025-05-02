package chapter04.level1.numberstring;

/*
페이지 141
 */
public class NumberStringAnswer {
    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        NumberStringAnswer ns = new NumberStringAnswer();
        System.out.println(ns.solution("one4seveneight"));
    }
}
