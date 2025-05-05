package chapter05.voweldictionary;

import java.util.ArrayList;
import java.util.List;

/*
페이지 180
 */
public class VowelDictionaryAnswer2 {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;

        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    public static void main(String[] args) {
        VowelDictionaryAnswer2 vowel = new VowelDictionaryAnswer2();
        System.out.println(vowel.solution("AAAAE"));
        System.out.println(vowel.solution("AAAE"));
        System.out.println(vowel.solution("I"));
        System.out.println(vowel.solution("EIO"));
    }
}
