package problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * CS5004 Spring2022 Jin Young Park HW1 CredentialsTest.java
 CredentialsTest is a class to test functions in the class Credentials.
 Includes getUsername, getPasswordHash, setUsername, setPasswordHash.
 */
class CredentialsTest {
    private static Credentials testCredentials;

    /**
     * setup, set up Credentials objects for testing each function.
     */
    @BeforeEach
    void setUp() {
        testCredentials = new Credentials("newuser", "user1234");
    }

    /**
     * Test if getUsername returns the right username value.
     */
    @Test
    void getUsername() {
        Assertions.assertEquals("newuser", testCredentials.getUsername());
    }
    /**
     * Test if getPasswordHash returns the right password value.
     */
    @Test
    void getPasswordHash() {
        Assertions.assertEquals("user1234", testCredentials.getPasswordHash());
    }
    /**
     * Test if setUsername sets the username correctly.
     * Checks the value of username before setting the username with different value.
     * Then checks the value of username to see if it is changed.
     */
    @Test
    void setUsername() {
        Assertions.assertEquals("newuser", testCredentials.getUsername());
        testCredentials.setUsername("changeduser");
        Assertions.assertEquals("changeduser", testCredentials.getUsername());
    }
    /**
     * Test if setPasswordHash sets the passwordHash correctly.
     * Checks the value of passwordHash before setting the passwordHash with different value.
     * Then checks the value of passwordHash to see if it is changed.
     */
    @Test
    void setPasswordHash() {
        Assertions.assertEquals("user1234", testCredentials.getPasswordHash());
        testCredentials.setPasswordHash("changedpw");
        Assertions.assertEquals("changedpw", testCredentials.getPasswordHash());
    }
}