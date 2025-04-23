package chapter01;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public final String name;
    private final List<PhoneNumber> numbers;

    public Person(String name) {
        this.name = name;
        numbers = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber number) {
        numbers.add(number);
    }

    /*
    number 가 전화번호 형식이면 추가하고 true 반환
    전화번호 형식이 아니면 추가하지 않고 false 반환
     */
    /*public boolean addPhoneNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        numbers.add(new PhoneNumber(number));
        return true;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }

    public boolean hasPhoneNumber(PhoneNumber number) {
        return numbers.contains(number);
    }
}
