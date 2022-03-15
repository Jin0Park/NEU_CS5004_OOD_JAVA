package problem02;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalLengthException;
import hw2exceptions.IllegalPickUpException;
import hw2exceptions.exceedDimensionException;
import hw2exceptions.lockerOccupiedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private int expectedMaxWidth;
  private int expectedMaxHeight;
  private int expectedMaxDepth;
  private MailItem testMailItem;
  private Recipient testRecipient;
  private MailItem defaultItemInLocker;
  private Locker testLocker;

  @BeforeEach
  void setUp() throws IllegalLengthException {
    testRecipient = new Recipient("Lionel", "Messi", "liomessi@psg.edu");
    testMailItem = new MailItem(8, 8, 8, testRecipient);
    testLocker = new Locker(10, 10, 10);
    //    testLockerWithItem = new Locker(10, 10, 10);
//    testLockerWithoutItem = new Locker(10, 10, 10);
    expectedMaxWidth = 10;
    expectedMaxHeight = 10;
    expectedMaxDepth = 10;
    defaultItemInLocker = null;

    // exception case where maximum width value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class,
        () -> testLocker = new Locker(-15, 10, 5));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
    // exception case where maximum height value is below 1
    Exception IllegalLengthException1 = assertThrows(Exception.class,
        () -> testLocker = new Locker(15, -10, 5));
    assertEquals("Invalid input!", IllegalLengthException1.getMessage());
    // exception case where maximum depth value is below 1
    Exception IllegalLengthException2 = assertThrows(Exception.class,
        () -> testLocker = new Locker(15, 10, -5));
    assertEquals("Invalid input!", IllegalLengthException2.getMessage());
  }

  @Test
  void getMaxWidth() {
    assertEquals(expectedMaxWidth, testLocker.getMaxWidth());
  }

  @Test
  void setMaxWidth() throws IllegalLengthException {
    testLocker.setMaxWidth(50);
    assertEquals(50, testLocker.getMaxWidth());

    // exception case where maximum width value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class,
        () -> testLocker.setMaxWidth(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getMaxHeight() {
    assertEquals(expectedMaxHeight, testLocker.getMaxHeight());
  }

  @Test
  void setMaxHeight() throws IllegalLengthException {
    testLocker.setMaxHeight(80);
    assertEquals(80, testLocker.getMaxHeight());

    // exception case where maximum height value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class,
        () -> testLocker.setMaxHeight(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getMaxDepth() {
    assertEquals(expectedMaxDepth, testLocker.getMaxDepth());
  }

  @Test
  void setMaxDepth() throws IllegalLengthException {
    testLocker.setMaxDepth(100);
    assertEquals(100, testLocker.getMaxDepth());

    // exception case where maximum depth value is below 1
    Exception IllegalLengthException = assertThrows(Exception.class,
        () -> testLocker.setMaxDepth(0));
    assertEquals("Invalid input!", IllegalLengthException.getMessage());
  }

  @Test
  void getItemInLocker() {
    // default state of the locker is null
    assertEquals(null, testLocker.getItemInLocker());
  }

  @Test
  void setItemInLocker() throws IllegalLengthException {
    Recipient newTestRecipient = new Recipient("Chris", "Ronaldo", "cr7@manu.edu");
    MailItem newTestMailItem = new MailItem(5, 5, 5, newTestRecipient);
    testLocker.setItemInLocker(newTestMailItem);
    assertEquals(newTestMailItem, testLocker.getItemInLocker());
  }

  @Test
  void addMail() throws IllegalLengthException, exceedDimensionException, lockerOccupiedException {
    Recipient newTestRecipient = new Recipient("Chris", "Ronaldo", "cr7@manu.edu");
    MailItem newTestMailItem = new MailItem(5, 5, 5, newTestRecipient);
    MailItem newTestMailItemInvalidWidth = new MailItem(15, 8, 8, newTestRecipient);
    MailItem newTestMailItemInvalidHeight = new MailItem(8, 15, 8, newTestRecipient);
    MailItem newTestMailItemInvalidDepth = new MailItem(8, 8, 15, newTestRecipient);
    // able to add mail in the locker which is empty
    testLocker.addMail((testMailItem));
    assertEquals(testMailItem, testLocker.getItemInLocker());
    // exception case where the locker is already filled
    Exception lockerOccupiedException = assertThrows(Exception.class,
        () -> testLocker.addMail(newTestMailItemInvalidWidth));
    assertEquals("The locker is occupied!", lockerOccupiedException.getMessage());
    testLocker.setItemInLocker(null);
    // exception case where the mail has larger width than the locker
    Exception exceedDimensionException = assertThrows(Exception.class,
        () -> testLocker.addMail(newTestMailItemInvalidWidth));
    assertEquals("Unable to put it in!", exceedDimensionException.getMessage());
    // exception case where the mail has larger height than the locker
    Exception exceedDimensionException1 = assertThrows(Exception.class,
        () -> testLocker.addMail(newTestMailItemInvalidHeight));
    assertEquals("Unable to put it in!", exceedDimensionException1.getMessage());
    // exception case where the mail has larger depth than the locker
    Exception exceedDimensionException2 = assertThrows(Exception.class,
        () -> testLocker.addMail(newTestMailItemInvalidDepth));
    assertEquals("Unable to put it in!", exceedDimensionException2.getMessage());
  }

  @Test
  void pickupMail()
      throws IllegalPickUpException, exceedDimensionException, lockerOccupiedException {
    Recipient newTestRecipient = new Recipient("Chris", "Ronaldo", "cr7@manu.edu");
    testLocker.addMail(testMailItem);
    // able to pick up the item since the recipient of the mail and the given recipient match
    assertEquals(testMailItem, testLocker.pickupMail(testRecipient));

    // exception case when the given recipient does not match with recipient of the mail in the locker
    Exception IllegalPickUpException = assertThrows(Exception.class,
        () -> testLocker.pickupMail(newTestRecipient));
    assertEquals("Not able to pick up!", IllegalPickUpException.getMessage());
    // exception case when there is no item in the locker
    testLocker.setItemInLocker(null);
    Exception IllegalPickUpException1 = assertThrows(Exception.class,
        () -> testLocker.pickupMail(testRecipient));
    assertEquals("Not able to pick up!", IllegalPickUpException1.getMessage());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testLocker.equals(testLocker));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testLocker.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Recipient newTestRecipient = new Recipient("Lucas", "Moura", "lucasMoura@tottenham.uk");
    assertFalse(testLocker.equals(newTestRecipient));
  }

  @Test
  void testEquals_DifferentInheritedFields()
      throws IllegalLengthException, exceedDimensionException, lockerOccupiedException {
    Recipient newTestRecipient = new Recipient("Chris", "Ronaldo", "cr7@manu.edu");
    MailItem newTestMailItem = new MailItem(15, 18, 10, newTestRecipient);
    Locker newTestLocker = new Locker(20, 20, 20);
    newTestLocker.addMail(newTestMailItem);
    assertFalse(testLocker.equals(newTestLocker));
  }

  @Test
  void testEquals_SameFieldsOverall() throws IllegalLengthException {
    Locker newTestLocker = new Locker(10, 10, 10);
    assertTrue(testLocker.equals(newTestLocker));
  }

  @Test
  void testEquals_DifferentWidthMax() throws IllegalLengthException {
    Locker newTestLocker = new Locker(20, 10, 10);
    assertFalse(testLocker.equals(newTestLocker));
  }

  @Test
  void testEquals_DifferentHeight() throws IllegalLengthException {
    Locker newTestLocker = new Locker(10, 20, 10);
    assertFalse(testLocker.equals(newTestLocker));
  }

  @Test
  void testEquals_DifferentDepth() throws IllegalLengthException {
    Locker newTestLocker = new Locker(15, 10, 20);
    assertFalse(testLocker.equals(newTestLocker));
  }

  @Test
  void testEquals_DifferentRecipient()
      throws IllegalLengthException, exceedDimensionException, lockerOccupiedException {
    Recipient newTestRecipient = new Recipient("Chris", "Ronaldo", "cr7@manu.edu");
    MailItem newTestMailItem = new MailItem(8, 8, 8, newTestRecipient);
    Locker newTestLocker = new Locker(15, 10, 20);
    newTestLocker.addMail(newTestMailItem);
    assertFalse(testLocker.equals(newTestLocker));
  }

  @Test
  void testHashCode() throws IllegalLengthException {
    Locker newTestLocker = new Locker(10, 10, 10);
    assertTrue(testLocker.hashCode() == newTestLocker.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Locker{" +
        "maxWidth=" + "10" +
        ", maxHeight=" + "10" +
        ", maxDepth=" + "10" +
        ", itemInLocker=" + null + '}';

    assertEquals(expectedString, testLocker.toString());
  }
}
