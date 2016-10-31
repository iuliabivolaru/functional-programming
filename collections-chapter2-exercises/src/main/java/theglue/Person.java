package theglue;

import java.util.*;
import java.util.function.IntPredicate;
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

    public static Integer determineNumberOfACharsInNames() {
        return people.stream()
                .map(person -> person.getName().chars()
                        .filter(c -> {
                            boolean a1 = c == 97;
                            return a1;
                        })
                        //caracterul 'a' se va considera ca are valoarea 1
                        .map(c -> 1)
                        .reduce(0, (a, b) -> a + b)
                ).reduce(0, (a, b) -> a + b);
    }

    //flatMap despacheteaza continutul stream<stream<...>>...
    public static Integer determineNumberOfACharsInNamesSecondMethod() {
        return people.stream()
                .flatMap(person -> person.getName().chars().mapToObj(c -> c))
                .reduce(0, (a, b) -> a + b);
    }

    public static List<Person> sortPeopleByAge() {
        return people.stream().sorted((o1, o2) -> new Integer(o1.getAge()).compareTo(o2.getAge())).collect(Collectors.toList());
    }

    public static List<Person> displayPeopleYoungerThan20() {
        return people.stream().filter(person -> person.getAge() < 20).collect(Collectors.toList());
    }

    public static Map<Integer, List<Person>> peopleGroupedByAge() {
        return people.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    public static Map<Character, Optional<Person>> displayOldestPeopleInGroupsByFirstCharInName() {
        return null;
    }
}
