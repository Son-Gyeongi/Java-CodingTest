package chapter04.level1.stringcontrol;

public class StringControlAnswer {
    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    public static void main(String[] args) {
        StringControlAnswer sc = new StringControlAnswer();
        System.out.println(sc.solution("a234"));
        System.out.println(sc.solution("1234"));
    }
}
