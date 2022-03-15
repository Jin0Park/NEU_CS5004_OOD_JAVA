package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DonationTest {

  private LocalDateTime testCreationDate;
  private LocalDateTime testProcessingDate;
  private float testAmount;
  private OneTimeDonation testOneTimeDonation;
  private MonthlyDonation testMonthlyDonation;
  private Pledges testPledges;
  private Pledges noProcessingPledges;

  @BeforeEach
  void setUp() {
    testCreationDate = LocalDateTime.of(2021, 11, 30, 15, 30);
    testProcessingDate = LocalDateTime.of(2022, 4, 5, 15, 30);
    testAmount = 350.00F;
    testOneTimeDonation = new OneTimeDonation(testCreationDate, testAmount);
    testMonthlyDonation = new MonthlyDonation(testCreationDate, testAmount);
    testPledges = new Pledges(testCreationDate, testAmount, testProcessingDate);
    noProcessingPledges = new Pledges(testCreationDate, testAmount, null);
  }

  @Test
  void getDate() {
    assertEquals(testCreationDate, testOneTimeDonation.getDate());
    assertEquals(testCreationDate, testMonthlyDonation.getDate());
    assertEquals(testCreationDate, testPledges.getDate());
  }

  @Test
  void getAmount() {
    assertEquals(testAmount, testOneTimeDonation.getAmount());
    assertEquals(testAmount, testMonthlyDonation.getAmount());
    assertEquals(testAmount, testPledges.getAmount());
  }

  @Test
  void getCancellationDate() {
    assertEquals(null, testMonthlyDonation.getCancellationDate());
  }

  @Test
  void setCancellationDate() throws InvalidDateException {
    LocalDateTime cancellationDate = LocalDateTime.of(2022, 3, 4, 16, 20);
    testMonthlyDonation.setCancellationDate(cancellationDate);
    assertEquals(cancellationDate, testMonthlyDonation.getCancellationDate());
    // Throws exception when the cancellation date is before the creation date
    LocalDateTime invalidDate = LocalDateTime.of(1994, 02, 23, 18, 30);
    Exception InvalidDateException = assertThrows(Exception.class,
        () -> testMonthlyDonation.setCancellationDate(invalidDate));
    assertEquals("The cancellation date cannot be before donation date",
        InvalidDateException.getMessage());
  }

  @Test
  void getProcessingDate() {
    LocalDateTime processingDate = LocalDateTime.of(2022, 4, 5, 15, 30);
    LocalDateTime noProcessingDate = null;
    assertEquals(processingDate, testPledges.getProcessingDate());
    assertEquals(noProcessingDate, noProcessingPledges.getProcessingDate());
  }

  @Test
  void setProcessingDate() throws InvalidDateException {
    LocalDateTime processingDate = LocalDateTime.of(2030, 11, 3, 8, 00);
    noProcessingPledges.setProcessingDate(processingDate);
    assertEquals(processingDate, noProcessingPledges.getProcessingDate());
    // Throws exception when the processing date is before the creation date
    LocalDateTime invalidDate = LocalDateTime.of(1994, 02, 23, 18, 30);
    Exception InvalidDateException = assertThrows(Exception.class,
        () -> noProcessingPledges.setProcessingDate(invalidDate));
    assertEquals("Processing Date cannot be before creation date",
        InvalidDateException.getMessage());
  }

  @Test
  void removeProcessingDate() {
    testPledges.removeProcessingDate();
    assertEquals(null, testPledges.getProcessingDate());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testOneTimeDonation.equals(testOneTimeDonation));
    assertTrue(testMonthlyDonation.equals(testMonthlyDonation));
    assertTrue(testPledges.equals(testPledges));
  }

  @Test
  void testEquals_DifferentObject() {
    NonProfit nonprofitOrg = new NonProfit("ngo", null, null);
    assertFalse(testOneTimeDonation.equals(nonprofitOrg));
    assertFalse(testMonthlyDonation.equals(nonprofitOrg));
    assertFalse(testPledges.equals(nonprofitOrg));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testOneTimeDonation.equals(null));
    assertFalse(testMonthlyDonation.equals(null));
    assertFalse(testPledges.equals(null));
  }

  @Test
  void testEquals_DifferentCreationDate() {
    LocalDateTime newCreatingDate = LocalDateTime.of(2022, 2, 8, 10, 10);
    OneTimeDonation newOneTime = new OneTimeDonation(newCreatingDate, testAmount);
    MonthlyDonation newMonthly = new MonthlyDonation(newCreatingDate, testAmount);
    Pledges newPledges = new Pledges(newCreatingDate, testAmount, testProcessingDate);
    assertFalse(testOneTimeDonation.equals(newOneTime));
    assertFalse(testMonthlyDonation.equals(newMonthly));
    assertFalse(testPledges.equals(newPledges));
  }

  @Test
  void testEquals_DifferentAmount() {
    float newAmount = 10.00F;
    OneTimeDonation newOneTime = new OneTimeDonation(testCreationDate, newAmount);
    MonthlyDonation newMonthly = new MonthlyDonation(testCreationDate, newAmount);
    Pledges newPledges = new Pledges(testCreationDate, newAmount, testProcessingDate);
    assertFalse(testOneTimeDonation.equals(newOneTime));
    assertFalse(testMonthlyDonation.equals(newMonthly));
    assertFalse(testPledges.equals(newPledges));
  }

  @Test
  void testEquals_DifferentCancellationDate() throws InvalidDateException {
    LocalDateTime newCancellationTime = LocalDateTime.of(2028, 2, 8, 10, 10);
    MonthlyDonation newMonthly = new MonthlyDonation(testCreationDate, testAmount);
    newMonthly.setCancellationDate(newCancellationTime);
    assertFalse(testMonthlyDonation.equals(newMonthly));
  }

  @Test
  void testEquals_DifferentProcessingDate() {
    LocalDateTime newProcessingDate = LocalDateTime.of(2028, 2, 8, 10, 10);
    Pledges newPledges = new Pledges(testCreationDate, testAmount, newProcessingDate);
    assertFalse(testPledges.equals(newPledges));
  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() {
    LocalDateTime newCreatingDate = LocalDateTime.of(2021, 11, 30, 15, 30);
    LocalDateTime newProcessingDate = LocalDateTime.of(2022, 4, 5, 15, 30);
    float newAmount = 350.00F;
    OneTimeDonation newOneTime = new OneTimeDonation(newCreatingDate, newAmount);
    MonthlyDonation newMonthly = new MonthlyDonation(newCreatingDate, newAmount);
    Pledges newPledges = new Pledges(newCreatingDate, newAmount, newProcessingDate);
    assertTrue(testMonthlyDonation.equals(newMonthly));
    assertTrue(testPledges.equals(newPledges));
  }

  @Test
  void testHashCode() {
    LocalDateTime newCreatingDate = LocalDateTime.of(2021, 11, 30, 15, 30);
    LocalDateTime newProcessingDate = LocalDateTime.of(2022, 4, 5, 15, 30);
    float newAmount = 350.00F;
    OneTimeDonation newOneTime = new OneTimeDonation(newCreatingDate, newAmount);
    MonthlyDonation newMonthly = new MonthlyDonation(newCreatingDate, newAmount);
    Pledges newPledges = new Pledges(newCreatingDate, newAmount, newProcessingDate);
    assertTrue(testOneTimeDonation.hashCode() == newOneTime.hashCode());
    assertTrue(testMonthlyDonation.hashCode() == newMonthly.hashCode());
    assertTrue(testPledges.hashCode() == newPledges.hashCode());
  }

  @Test
  void testToString() {
    String expectedOneTimeDonation = "Donation{" +
        "date=" + "2021-11-30T15:30" +
        ", amount=" + "350.0" +
        '}';

    String expectedMonthlyDonation = "MonthlyDonation{" +
        "date=" + "2021-11-30T15:30" +
        ", amount=" + "350.0" +
        ", cancellationDate=" + "null" +
        '}';

    String expectedPledge = "Pledges{" +
        "date=" + "2021-11-30T15:30" +
        ", amount=" + "350.0" +
        ", processingDate=" + "2022-04-05T15:30" +
        '}';

    assertTrue(expectedOneTimeDonation.equals(testOneTimeDonation.toString()));
    assertTrue(expectedMonthlyDonation.equals(testMonthlyDonation.toString()));
    assertTrue(expectedPledge.equals(testPledges.toString()));
  }
}