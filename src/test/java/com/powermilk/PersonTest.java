package com.powermilk;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Person class")
@SelectPackages("com.powermilk")
class PersonTest {
    private static final Logger log = LoggerFactory.getLogger(PersonTest.class);
    private static Person person1;
    private static Person person2;

    @BeforeEach
    void init() {
        person1 = new Person("John", 23);
        person2 = new Person("Mary", 71);
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        person1 = null;
        person2 = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Test that equals() is reflexive")
    void shouldReturnTrueForReflexive() {
        assertEquals(person1, person1);
        assertEquals(person2, person2);

        assertSame(person1, person1);
        assertSame(person2, person2);

        log.info("Test for checking that equals() is reflexive!");
    }

    @Test
    @DisplayName("Test that equals() is symmetric")
    void shouldReturnTrueForSymmetric() {
        Person personOne = new Person("John", 23);

        assertEquals(personOne, person1);
        assertEquals(person1, personOne);

        assertTrue(person1.equals(personOne) && personOne.equals(person1));

        assertNotSame(person1, personOne);

        log.info("Test for checking that equals() is symmetric!");
    }

    @Test
    @DisplayName("Test that equals() is transitive")
    void shouldReturnTrueForTransitive() {
        Person personOne = new Person("John", 23);
        Person personTwo = new Person("John", 23);

        assertEquals(person1, personOne);
        assertEquals(personOne, personTwo);
        assertEquals(person1, personTwo);

        assertTrue(person1.equals(personOne) && personOne.equals(personTwo) && person1.equals(personTwo));

        assertNotSame(person1, personOne);
        assertNotSame(personOne, personTwo);
        assertNotSame(person1, personTwo);

        log.info("Test for checking that equals() is transitive!");
    }

    @Test
    @DisplayName("Test that equals() returns false for null")
    void shouldReturnFalseForNull() {
        assertNotEquals(person1, null);
        assertNotEquals(person2, null);

        log.info("Test for checking that equals() returns false for null!");
    }

    @Test
    @DisplayName("Test that equals() returns false for two different")
    void shouldReturnFalseForTwoDifferentObject() {
        assertNotEquals(person1, person2);

        log.info("Test for checking that equals() returns false for two different!");
    }

    @Test
    @DisplayName("Test that hashcode() returns true for self")
    void shouldHashcodeReturnsTrueForSelf() {
        assertEquals(person1.hashCode(), person1.hashCode());
        assertEquals(person2.hashCode(), person2.hashCode());

        assertSame(person1, person1);
        assertSame(person2, person2);

        log.info("Test for checking that hashcode() returns true for self passed!");

    }

    @Test
    @DisplayName("Test that hashcode() returns true for two same objects")
    void shouldHashcodeReturnsTrueForTwoSameObjects() {
        Person personOne = new Person("John", 23);
        Person personTwo = new Person("Mary", 71);

        assertNotSame(person1, personOne);
        assertNotSame(person2, personTwo);

        assertEquals(person1.hashCode(), personOne.hashCode());
        assertEquals(person2.hashCode(), personTwo.hashCode());

        log.info("Test for checking that hashcode() returns true for two same objects passed!");
    }

    @Test
    @DisplayName("Test contract equals-hashcode")
    void shouldContractPass() {
        EqualsVerifier.forClass(Person.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .usingGetClass()
                .verify();
        log.info("Test for contract equals-hashcode passed!");
    }

    @Test
    @DisplayName("Test that toString() is generating empty string")
    void shouldGenerateEmptyString() {
        Person personOne = new Person();

        String actual = personOne.toString();
        String expected = "[name=<null>,age=0]";

        assertTrue(actual.contains(expected));

        log.info("Test for checking that toString() is generating empty string!");
    }

    @Test
    @DisplayName("Test that toString() is generating properly")
    void shouldGenerateValidString() {
        String actual1 = person1.toString();
        String expected1 = "[name=John,age=23]";

        String actual2 = person2.toString();
        String expected2 = "[name=Mary,age=71]";

        assertTrue(actual1.contains(expected1));
        assertTrue(actual2.contains(expected2));

        log.info("Test for checking that toString() is generating properly!");
    }
}
