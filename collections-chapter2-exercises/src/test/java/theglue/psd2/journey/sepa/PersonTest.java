package theglue.psd2.journey.sepa;

import org.junit.Assert;
import org.junit.Test;

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
}
