package theglue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private int age;
    static List<Person> people =
            Arrays.asList(
                    new Person("Max", 18),
                    new Person("Peter", 23),
                    new Person("Pamela", 23),
                    new Person("David", 12));

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Person> displayPeopleWithStartingLetter(String letter) {

        return people.stream().filter(person -> person.getName().startsWith(letter)).collect(Collectors.toList());
    }

    public static Map<Integer, List<Person>> groupPeopleByAge() {

        return people.stream().sorted().limit(2).collect(Collectors.groupingBy(p -> p.age));
    }

    public static Optional<Person> determineOldestPerson() {

        return people
                .stream()
                .reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2);
    }
//nu intoarce un optional - avem valoarea identitate care se va returna oricum
    public static Person determineAggregatedNamesAndAges() {
        return people
                .stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
    }
}
