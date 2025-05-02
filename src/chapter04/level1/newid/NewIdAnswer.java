package chapter04.level1.newid;

public class NewIdAnswer {
    public String solution(String newId) {
        // 1 단계
        newId = newId.toLowerCase();

        // 2단계
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");

        // 3단계
        newId = newId.replaceAll("\\.+", ".");

        // 4단계
        newId = newId.replaceAll("^\\.+|\\.+$", "");

        // 5단계
        if (newId.isEmpty()) newId = "a";

        // 6단계
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }

        // 7단계
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }

    public static void main(String[] args) {
        NewIdAnswer newId = new NewIdAnswer();
        System.out.println(newId.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(newId.solution("z-+.^."));
        System.out.println(newId.solution("=.="));
        System.out.println(newId.solution("123_.def"));
        System.out.println(newId.solution("abcdefghijklmn.p"));
    }
}
