package chapter04.caesarcipher;

public class CaesarCipherAnswer {
    // c를 n만큼 밀어 반환
    private char push(char c, int n) {
        // 1-A. 알파벳이 아닌 경우 문자를 그대로 이어 붙이기
        if (!Character.isAlphabetic(c)) return c; // if (!('a'<=c<='z') && !('A'<=c<='Z'))

        // 1-B. 알파벳인 경우 n만큼 밀어 이어 붙이기
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // c를 n만큼 민 문자를 builder 에 이어 붙이기
            builder.append(push(c, n));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        CaesarCipherAnswer cc = new CaesarCipherAnswer();
        System.out.println(cc.solution("AB", 1));
        System.out.println(cc.solution("z", 1));
        System.out.println(cc.solution("a B z", 4));
    }
}
