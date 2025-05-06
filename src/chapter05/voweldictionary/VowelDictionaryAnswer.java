package chapter05.voweldictionary;

import java.util.ArrayList;
import java.util.List;

/*
페이지 180
 */
public class VowelDictionaryAnswer {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }

    public int solution(String word) {
        return generate("").indexOf(word);
    }

    public static void main(String[] args) {
        VowelDictionaryAnswer vowel = new VowelDictionaryAnswer();
        System.out.println(vowel.solution("AAAAE"));
        System.out.println(vowel.solution("AAAE"));
        System.out.println(vowel.solution("I"));
        System.out.println(vowel.solution("EIO"));
    }
}
