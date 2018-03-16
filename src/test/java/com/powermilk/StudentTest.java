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

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Student class")
@SelectPackages("com.powermilk")
class StudentTest {
    private static final Logger log = LoggerFactory.getLogger(StudentTest.class);

    @BeforeEach
    void init() {
        log.info("Test started!");
    }

    @AfterEach
    void tearDown() {
        log.info("Test finished!");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .withRedefinedSubclass(Student.class)
                .usingGetClass()
                .verify();
        log.info("Test passed!");
    }
}