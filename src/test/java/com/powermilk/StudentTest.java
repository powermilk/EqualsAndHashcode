package com.powermilk;

import nl.jqno.equalsverifier.EqualsVerifier;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Student class")
@SelectPackages("com.powermilk")
class StudentTest {
    private static final Logger log = LoggerFactory.getLogger(StudentTest.class);

    private static Student student1;
    private static Student student2;

    @BeforeEach
    void init() {
        student1 = new Student("Andrew", 10, "Elementary");
        student2 = new Student("Emma", 19, "High School");
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        student1 = null;
        student2 = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Test that equals() is reflexive")
    void shouldReturnTrueForReflexive() {
        assertEquals(student1, student1);
        assertEquals(student2, student2);

        assertSame(student1, student1);
        assertSame(student2, student2);

        log.info("Test for checking that equals() is reflexive!");
    }

    @Test
    @DisplayName("Test that equals() is symmetric")
    void shouldReturnTrueForSymmetric() {
        Student studentOne = new Student("Andrew", 10, "Elementary");

        assertEquals(studentOne, student1);
        assertEquals(student1, studentOne);

        assertTrue(student1.equals(studentOne) && studentOne.equals(student1));

        assertNotSame(student1, studentOne);

        log.info("Test for checking that equals() is symmetric!");
    }

    @Test
    @DisplayName("Test that equals() is transitive")
    void shouldReturnTrueForTransitive() {
        Student studentOne = new Student("Andrew", 10, "Elementary");
        Student studentTwo = new Student("Andrew", 10, "Elementary");

        assertEquals(student1, studentOne);
        assertEquals(studentOne, studentTwo);
        assertEquals(student1, studentTwo);

        assertTrue(student1.equals(studentOne) && studentOne.equals(studentTwo)
                && student1.equals(studentTwo));


        assertNotSame(student1, studentOne);
        assertNotSame(studentOne, studentTwo);
        assertNotSame(student1, studentTwo);

        log.info("Test for checking that equals() is transitive!");
    }

    @Test
    @DisplayName("Test that equals() returns false for null")
    void shouldReturnFalseForNull() {
        assertNotEquals(student1, null);
        assertNotEquals(student2, null);

        log.info("Test for checking that equals() returns false for null!");
    }

    @Test
    @DisplayName("Test that equals() returns false for two different")
    void shouldReturnFalseForTwoDifferentObject() {
        assertNotEquals(student1, student2);

        log.info("Test for checking that equals() returns false for two different!");
    }

    @Test
    @DisplayName("Test that hashcode() returns true for self")
    void shouldHashcodeReturnsTrueForSelf() {
        assertEquals(student1.hashCode(), student1.hashCode());
        assertEquals(student2.hashCode(), student2.hashCode());

        assertSame(student1, student1);
        assertSame(student2, student2);

        log.info("Test for checking that hashcode() returns true for self passed!");

    }

    @Test
    @DisplayName("Test that hashcode() returns true for two same objects")
    void shouldHashcodeReturnsTrueForTwoSameObjects() {
        Student studentOne = new Student("Andrew", 10, "Elementary");
        Student studentTwo = new Student("Emma", 19, "High School");

        assertNotSame(student1, studentOne);
        assertNotSame(student2, studentTwo);

        assertEquals(student1.hashCode(), studentOne.hashCode());
        assertEquals(student2.hashCode(), studentTwo.hashCode());

        log.info("Test for checking that hashcode() returns true for two same objects passed!");
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .withRedefinedSubclass(Student.class)
                .usingGetClass()
                .verify();
        log.info("Test passed!");

        log.info("Test for contract equals-hashcode passed!");
    }

    @Test
    @DisplayName("Test that toString() is generating empty string")
    void shouldGenerateEmptyString() {
        Student student = new Student();

        String actual = student.toString();
        String expected = "[school=<null>,name=<null>,age=0]";

        assertTrue(actual.contains(expected));

        log.info("Test for checking that toString() is generating empty string!");
    }

    @Test
    @DisplayName("Test that toString() is generating properly")
    void shouldGenerateValidString() {
        String actual1 = student1.toString();
        String expected1 = "[school=Elementary,name=Andrew,age=10";

        String actual2 = student2.toString();

        System.out.println("XXXX " + student2.toString());

        String expected2 = "[school=High School,name=Emma,age=19]";

        assertTrue(actual1.contains(expected1));
        assertTrue(actual2.contains(expected2));

        log.info("Test for checking that toString() is generating properly!");
    }
}