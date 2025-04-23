package chapter01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String phoneNumber = scanner.nextLine();

        // 1. 전화번호 나타내기
//        System.out.println(new PhoneNumber("010-1234-5678"));
//        System.out.println(new PhoneNumber("010 1234 5678"));
//        System.out.println(new PhoneNumber("01012345678"));

        // 2. 전화번호부의 사람 나타내기
//        Person person = new Person("홍길동");
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//        person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
//        person.addPhoneNumber(new PhoneNumber("01012345678"));
//        System.out.println(person);

        // 3. 사람과 전화번호 비교하기
//        System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));

        // 4. 전화번호부 나타내기
//        Person person1 = new Person("홍길동");
//        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));
//
//        Person person2 = new Person("김철수");
//        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));
//
//        Person person3 = new Person("이영희");
//        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));
//
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.addPerson(person1);
//        phoneBook.addPerson(person2);
//        phoneBook.addPerson(person3);
//
//        System.out.println(phoneBook);

        // 4-1. 중복 저장 없애기
//        Person person = new Person("홍길동");
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.addPerson(person);
//        phoneBook.addPerson(person);
//
//        System.out.println(phoneBook);

        // 4-2. PhoneBook 클래스의 검색 메서드 search() 테스트
        Person person1 = new Person("홍길동");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person person2 = new Person("김철수");
        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

        Person person3 = new Person("이영희");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
        System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
        System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
        System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
    }
}
