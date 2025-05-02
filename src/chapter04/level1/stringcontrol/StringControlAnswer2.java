package chapter04.level1.stringcontrol;

public class StringControlAnswer2 {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        StringControlAnswer2 sc = new StringControlAnswer2();
        System.out.println(sc.solution("a234"));
        System.out.println(sc.solution("1234"));
    }
}
