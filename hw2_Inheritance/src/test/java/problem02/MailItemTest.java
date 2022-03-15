package problem02;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalLengthException;
import java.rmi.server.ExportException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem01.Vehicle;

class MailItemTest {

  private int expectedWidth;
  private int expectedHeight;
  private int expectedDepth;
  private Recipient testRecipient;
  private MailItem testMailItem;

  @BeforeEach
  void setUp() throws IllegalLengthException {
    testRecipient = new Recipient("Dominic", "Park", "dominic@email.edu");
    testMailItem = new MailItem(10, 15, 5, testRecipient);
    expectedWidth = 10;
    expectedHeight = 15;
    expectedDepth = 5;

    // exception case where width value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class,
        () -> testMailItem = new MailItem(-1, 10, 5, testRecipient));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
    // exception case where height value is below 1
    Exception IllegalLengthException1 = assertThrows(Exception.class,
        () -> testMailItem = new MailItem(10, -10, 5, testRecipient));
    assertEquals("Invalid input!", IllegalLengthException1.getMessage());
    // exception case where depth value is below 1
    Exception IllegalLengthException2 = assertThrows(Exception.class,
        () -> testMailItem = new MailItem(10, 10, -5, testRecipient));
    assertEquals("Invalid input!", IllegalLengthException2.getMessage());
  }

  @Test
  void getWidth() {
    assertEquals(expectedWidth, testMailItem.getWidth());
  }

  @Test
  void setWidth() throws IllegalLengthException {
    testMailItem.setWidth(15);
    assertEquals(15, testMailItem.getWidth());

    // exception case where width value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class, () -> testMailItem.setWidth(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testMailItem.getHeight());
  }

  @Test
  void setHeight() throws IllegalLengthException {
    testMailItem.setHeight(50);
    assertEquals(50, testMailItem.getHeight());

    // exception case where height value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class, () -> testMailItem.setHeight(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getDepth() {
    assertEquals(expectedDepth, testMailItem.getDepth());
  }

  @Test
  void setDepth() throws IllegalLengthException {
    testMailItem.setDepth(20);
    assertEquals(20, testMailItem.getDepth());

    // exception case where depth value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class, () -> testMailItem.setDepth(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getCurrentRecipient() {
    assertEquals(testRecipient, testMailItem.getCurrentRecipient());
  }

  @Test
  void setCurrentRecipient() {
    Recipient newTestRecipient = new Recipient("Harry", "Kane", "harrykane@tottenham.uk");
    testMailItem.setCurrentRecipient(newTestRecipient);
    assertEquals(newTestRecipient, testMailItem.getCurrentRecipient());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testMailItem.equals(testMailItem));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testMailItem.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Recipient newTestRecipient = new Recipient("Lucas", "Moura", "lucasMoura@tottenham.uk");
    assertFalse(testMailItem.equals(newTestRecipient));
  }

  @Test
  void testEquals_DifferentInheritedFields() throws IllegalLengthException {
    Recipient newTestRecipient = new Recipient("Lucas", "Moura", "lucasMoura@tottenham.uk");
    MailItem newTestMailItem = new MailItem(15, 18, 10, newTestRecipient);
    assertFalse(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testEquals_SameFieldsOverall() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(10, 15, 5, testRecipient);
    assertTrue(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testEquals_DifferentWidth() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(20, 15, 5, testRecipient);
    assertFalse(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testEquals_DifferentHeight() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(10, 10, 5, testRecipient);
    assertFalse(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testEquals_DifferentDepth() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(10, 15, 20, testRecipient);
    assertFalse(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testEquals_DifferentRecipient() throws IllegalLengthException {
    Recipient newTestRecipient = new Recipient("Lucas", "Moura", "lucasMoura@tottenham.uk");
    MailItem newTestMailItem = new MailItem(10, 15, 20, newTestRecipient);
    assertFalse(testMailItem.equals(newTestMailItem));
  }

  @Test
  void testHashCode() throws IllegalLengthException {
    MailItem newTestMailItem = new MailItem(10, 15, 5, testRecipient);
    assertTrue(testMailItem.hashCode() == newTestMailItem.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "MailItem{" +
        "width=" + "10" +
        ", height=" + "15" +
        ", depth=" + "5" +
        ", currentRecipient=" + testRecipient +
        '}';
    assertEquals(expectedString, testMailItem.toString());
  }
}