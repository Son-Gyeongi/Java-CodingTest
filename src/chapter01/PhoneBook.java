package chapter01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {
    private final Set<Person> people;

    public PhoneBook() {
        this.people = new HashSet<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "people=" + people +
                '}';
    }

    public Person search(PhoneNumber number) {
        return people.stream()
                .filter(p -> p.hasPhoneNumber(number))
                .findFirst()
                .orElse(null);
    }
}
