package problem03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CS5004 Spring2022 Jin Young Park HW1 IdentifierTest.java
   UserAccountTest is a class to test functions in the class Account.
   Includes getUsername, getYearCreated, getCountryCreated.
 */

class IdentifierTest {
    private static Identifier testAccount;

    /**
     * setup, set up UserAccount objects for testing each function.
     */
    @BeforeEach
    void setUp() {
        testAccount = new Identifier("jpmorgan", 1921, "USA");
    }

    /**
     * Test if getUsername returns the right username value.
     */
    @Test
    void getUsername() {
        Assertions.assertEquals("jpmorgan", testAccount.getUsername());
    }
    /**
     * Test if getYearCreated returns the correct value.
     */
    @Test
    void getYearCreated() {
        Assertions.assertEquals(1921, testAccount.getYearCreated());
    }
    /**
     * Test if getCountryCreated returns the correct value.
     */
    @Test
    void getCountryCreated() {
        Assertions.assertEquals("USA", testAccount.getCountryCreated());
    }
}