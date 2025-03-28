package CodeJava;

import java.util.ArrayList;
import java.util.List;

public class recordTest {
    public record Person(int age, String name) {
    }

    public static void main(String[] args) {
        System.out.println();

        List<Person> people = new ArrayList<>();
        people.add(new Person(20, "John Doe"));
        people.add(new Person(25, "Jane smith"));

        people.stream().forEach(person -> {
            System.out.println("Name: " + person.name() + ", Age: " + person.age());
        });

    }

}
