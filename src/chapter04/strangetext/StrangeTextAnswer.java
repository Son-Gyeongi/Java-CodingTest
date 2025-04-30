package chapter04.strangetext;

/*
페이지 114
 */
public class StrangeTextAnswer {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            // c를 적절히 변환하여 builder 에 추가
            // 1-A. 문자가 공백일 경우
            if (Character.isSpaceChar(c)) { // !Character.isAlphabetic(c) 문자가 아닐 때(공백일 때)
                // 공백 처리
                // 1-A-i. 그대로 이어 붙이기
                builder.append(c);
                // 1-A-ii. 다음 등장하는 알파벳은 대문자
                toUpper = true;
            } else { // 1-B. 공백 문자가 아닌 경우
                // 알파벳 변환
                // 1-B-i. 대,소문자 변환하여 이어 붙이기
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                // 1-B-ii. 다음 등장하는 알파벳의 대,소문자는 현재 변환하는 문자와 반대
                toUpper = !toUpper;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        StrangeTextAnswer st = new StrangeTextAnswer();
        System.out.println(st.solution("try hello world"));
        System.out.println(st.solution("a          a   "));
    }
}
