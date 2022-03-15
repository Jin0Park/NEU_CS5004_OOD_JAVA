package problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CS5004 Spring2022 Jin Young Park HW1 UserTest.java
 UserTest is a class to test functions in the class User.
 Includes setFirstname, setLastname, setPhoneNumber, setEmailAddress,
 setCredentialPair, getFirstname, getLastname, getPhoneNumber,
 getEmailAddress, getCredentialPair.
 */
class UserTest {
    private static Credentials testCredentials;
    private static User testUser;

    /**
     * setup, set up User and Credentials objects for testing each function.
     */
    @BeforeEach
    void setUp() throws Exception {
        testCredentials = new Credentials("username", "user1234");

        // exception case where phone number length is not 10
        Exception exception = assertThrows(Exception.class, () ->
                testUser = new User("Dominic", "Park", "12345",
                         "dominicpark@neu.edu", testCredentials));
        assertEquals("The given phone number is not valid.", exception.getMessage());
        // valid case
        testUser = new User("Dominic", "Park", "1234567890",
                 "dominicpark@neu.edu", testCredentials);
    }
    /**
     * Test if setFirstname sets the firstname correctly.
       Checks the value of firstname before setting the firstname with different value.
       Then checks the value of firstname to see if it is changed.
     */
    @Test
    void setFirstname() {
        Assertions.assertEquals("Dominic", testUser.getFirstname());
        testUser.setFirstname("NewFirst"); // set to something else bc firstname is already first
        Assertions.assertEquals("NewFirst", testUser.getFirstname());
    }
    /**
     * Test if setLastname sets the lastname correctly.
       Checks the value of lastname before setting the lastname with different value.
       Then checks the value of lastname to see if it is changed.
     */
    @Test
    void setLastname() {
        Assertions.assertEquals("Park", testUser.getLastname());
        testUser.setLastname("NewLast");
        Assertions.assertEquals("NewLast", testUser.getLastname());
    }
    /**
     * Test if setPhoneNumber sets the phoneNumber correctly.
       Checks the value of phoneNumber before setting the phoneNumber with different value.
       Then checks the value of phoneNumber to see if it is changed.
       Also tests exception case
     */
    @Test
    void setPhoneNumber() throws Exception {
        Assertions.assertEquals("1234567890", testUser.getPhoneNumber());
        testUser.setPhoneNumber("0000000000");
        Assertions.assertEquals("0000000000", testUser.getPhoneNumber());
        // testing exception case where phone number length is not 10
        Exception exception = assertThrows(Exception.class, () -> testUser.setPhoneNumber("007"));
        assertEquals("The given phone number is not valid.", exception.getMessage());
    }
    /**
     * Test if setEmailAddress sets the emailAddress correctly.
       Checks the value of emailAddress before setting the emailAddress with different value.
       Then checks the value of emailAddress to see if it is changed.
     */
    @Test
    void setEmailAddress() {
        Assertions.assertEquals("dominicpark@neu.edu", testUser.getEmailAddress());
        testUser.setEmailAddress("NEWEMAIL@neu.edu");
        Assertions.assertEquals("NEWEMAIL@neu.edu", testUser.getEmailAddress());
    }
    /**
     * Test if setCredentialPair sets the credentialPair correctly.
       Checks the username and password of credentialPair
       before setting the credentialPair with different value.
       Then checks the username and password of credentialPair
       to see if it is changed.
     */
    @Test
    void setCredentialPair() {
        Assertions.assertEquals(testCredentials.getUsername(), testUser.getCredentialPair().getUsername());
        Assertions.assertEquals(testCredentials.getPasswordHash(), testUser.getCredentialPair().getPasswordHash());
        Credentials changedPair = new Credentials("changeduser", "changed1234");
        testUser.setCredentialPair(changedPair);
        Assertions.assertEquals(changedPair.getUsername(), testUser.getCredentialPair().getUsername());
        Assertions.assertEquals(changedPair.getPasswordHash(), testUser.getCredentialPair().getPasswordHash());
    }
    /**
     * Checks getFirstname returns the correct value.
     */
    @Test
    void getFirstname() {
        Assertions.assertEquals("Dominic", testUser.getFirstname());
    }
    /**
     * Checks getLastname returns the correct value.
     */
    @Test
    void getLastname() {
        Assertions.assertEquals("Park", testUser.getLastname());
    }
    /**
     * Checks getPhoneNumber returns the correct value.
     */
    @Test
    void getPhoneNumber() {
        Assertions.assertEquals("1234567890", testUser.getPhoneNumber());
    }
    /**
     * Checks getEmailAddress returns the correct value.
     */
    @Test
    void getEmailAddress() {
        Assertions.assertEquals("dominicpark@neu.edu", testUser.getEmailAddress());
    }
    /**
     * Checks getCredentialPair returns the correct value.
     */
    @Test
    void getCredentialPair() {
        Assertions.assertEquals(testCredentials, testUser.getCredentialPair());
    }
}