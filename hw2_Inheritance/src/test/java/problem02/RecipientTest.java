package problem02;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient testRecipient;
  private String expectedFirstname;
  private String expectedLastname;
  private String expectedEmailAddress;

  @BeforeEach
  void setUp() {
    testRecipient = new Recipient("Dominic", "Park", "dominic@email.edu");
    expectedFirstname = "Dominic";
    expectedLastname = "Park";
    expectedEmailAddress = "dominic@email.edu";
  }

  @Test
  void getFirstname() {
    assertEquals(expectedFirstname, testRecipient.getFirstname());
  }

  @Test
  void setFirstname() {
    testRecipient.setFirstname("Jin");
    assertEquals("Jin", testRecipient.getFirstname());
  }

  @Test
  void getLastname() {
    assertEquals(expectedLastname, testRecipient.getLastname());
  }

  @Test
  void setLastname() {
    testRecipient.setLastname("Jackson");
    assertEquals("Jackson", testRecipient.getLastname());
  }

  @Test
  void getEmailAddress() {
    assertEquals(expectedEmailAddress, testRecipient.getEmailAddress());
  }

  @Test
  void setEmailAddress() {
    testRecipient.setEmailAddress("jinpark@email.edu");
    assertEquals("jinpark@email.edu", testRecipient.getEmailAddress());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testRecipient.equals(testRecipient));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRecipient.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(5, 3, 7, testRecipient);
    assertFalse(testRecipient.equals(newTestMailItem));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Recipient newTestRecipient = new Recipient("Will", "James", "willie@email.edu");
    assertFalse(testRecipient.equals(newTestRecipient));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Recipient newTestRecipient = new Recipient("Dominic", "Park", "dominic@email.edu");
    assertTrue(testRecipient.equals(newTestRecipient));
  }

  @Test
  void testEquals_DifferentFirstname() {
    Recipient newTestRecipient = new Recipient("Jin", "Park", "dominic@email.edu");
    assertFalse(testRecipient.equals(newTestRecipient));
  }

  @Test
  void testEquals_DifferentLastname() {
    Recipient newTestRecipient = new Recipient("Dominic", "Simon", "dominic@email.edu");
    assertFalse(testRecipient.equals(newTestRecipient));
  }

  @Test
  void testEquals_DifferentEmailAddress() {
    Recipient newTestRecipient = new Recipient("Dominic", "Park", "domipark@email.edu");
    assertFalse(testRecipient.equals(newTestRecipient));
  }

  @Test
  void testHashCode() {
    Recipient newTestRecipient = new Recipient("Dominic", "Park", "dominic@email.edu");
    assertTrue(testRecipient.hashCode() == newTestRecipient.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Recipient{" +
        "firstname='" + "Dominic" + '\'' +
        ", lastname='" + "Park" + '\'' +
        ", emailAddress='" + "dominic@email.edu" + '\'' +
        '}';
    assertEquals(expectedString, testRecipient.toString());
  }
}