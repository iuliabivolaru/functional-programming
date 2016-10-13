package theglue;

import org.junit.Assert;
import org.junit.Test;
import theglue.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonTest {

    @Test
    public void givenAListOfPeople_whenCheckStartLetter_thenDisplayNamesStartingWithSpecifiedLetter() {
        List<Person> filteredByName = Person.displayPeopleWithStartingLetter("P");
        Assert.assertEquals(filteredByName.size(), 2);
    }

    @Test
    public void givenAListOfPeople_whenGroupByAge_displayAgeWithPeople() {
        Map<Integer, List<Person>> grouped = Person.groupPeopleByAge();
        //count or test ages
    }

    @Test
    public void givenAListOfPeople_whenReduce_verifyOldestPerson() {
        Optional<Person> oldest = Person.determineOldestPerson();
        Assert.assertEquals(oldest.map(person -> person.getName()).orElse("stranger"), "Pamela");
    }

    @Test
    public void givenAListOfPeople_whenAggregate_verifyAggregatedAge() {
        Person aggregated = Person.determineAggregatedNamesAndAges();
        Assert.assertEquals(aggregated.getAge(), 76);
        Assert.assertEquals(aggregated.getName(), "MaxPeterPamelaDavid");
    }

    @Test
    public void givenAListOfPeople_whenAggregate_verifyTotalNumberOfAChars() {
        Integer charsANumber = Person.determineNumberOfACharsInNames();
        Assert.assertEquals(4, charsANumber.intValue());
    }

    @Test
    public void givenAListOfPeople_whenSort_verifySorted() {
        List<Person> sorted = Person.sortPeopleByAge();
        Assert.assertTrue(sorted.get(0).getAge() < sorted.get(1).getAge());
    }

    @Test
    public void givenAListOfPeople_whenCollect_verifyPeopleYoungerThan20() {
        List<Person> peopleYounger20 = Person.displayPeopleYoungerThan20();
        Assert.assertEquals(peopleYounger20.size(), 2);
    }

    @Test
    public void givenAListOfPeople_whenCollect_groupPeopleByAge() {
        Map<Integer, List<Person>> peopleGroupedByAge = Person.peopleGroupedByAge();
        Assert.assertEquals(peopleGroupedByAge.size(), 3);
    }

    @Test
    public void givenAListOfPeople_whenCollect_oldestPersonInGroup() {
        Map<Character, Optional<Person>> oldestPersonInEachGroup = Person.displayOldestPeopleInGroupsByFirstCharInName();
        Assert.assertEquals(oldestPersonInEachGroup.size(), 3);
    }

}
