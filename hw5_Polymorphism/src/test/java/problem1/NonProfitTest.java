package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class NonProfitTest {
  private String testName;
  private HashMap<Integer, ArrayList<Donation>> testCollection;
  private ArrayList<MonthlyDonation> testMonthlyList;
  private NonProfit testNonProfit;
  private LocalDateTime testCreationDate;
  private LocalDateTime testProcessingDate;
  private LocalDateTime testMonthlyDate2;
  private LocalDateTime testMonthlyDate3;
  private float testAmount;
  private float monthlyAmount;
  private float pledgeAmount;
  private OneTimeDonation testOneTimeDonation;
  private OneTimeDonation testOneTimeDonation1;
  private MonthlyDonation testMonthlyDonation1;
  private MonthlyDonation testMonthlyDonation2;
  private MonthlyDonation testMonthlyDonation3;
  private Pledges testPledges;
  private Pledges noProcessingPledges;

  @BeforeEach
  void setUp() {
    testName = "Red Cross";
    testCollection = new HashMap<>();
    testMonthlyList = new ArrayList<>();
    testNonProfit = new NonProfit(testName, testCollection, testMonthlyList);

    testCreationDate = LocalDateTime.of(2021, 6, 1, 15, 30);
    testProcessingDate = LocalDateTime.of(2022, 4, 5, 15, 30);

    testAmount = 350.00F;
    testOneTimeDonation = new OneTimeDonation(testCreationDate, testAmount);
    testOneTimeDonation1 = new OneTimeDonation(testProcessingDate, testAmount);

    monthlyAmount = 25.00F;
    testMonthlyDate2 = LocalDateTime.of(2021, 12, 30, 15, 30);
    testMonthlyDate3 = LocalDateTime.of(2020, 9, 15, 15, 30);
    testMonthlyDonation1 = new MonthlyDonation(testCreationDate, monthlyAmount);
    testMonthlyDonation2 = new MonthlyDonation(testMonthlyDate2, monthlyAmount);
    testMonthlyDonation3 = new MonthlyDonation(testMonthlyDate3, monthlyAmount);

    pledgeAmount = 30000.00F;
    testPledges = new Pledges(testCreationDate, pledgeAmount, testProcessingDate);
    noProcessingPledges = new Pledges(testCreationDate, pledgeAmount, null);
  }

  @Test
  void getOrganizationName() {
    assertEquals("Red Cross", testNonProfit.getOrganizationName());
  }

  @Test
  void setOrganizationName() {
    testNonProfit.setOrganizationName("Blue Cross");
    assertEquals("Blue Cross", testNonProfit.getOrganizationName());
  }

  @Test
  void getCollection() {
    HashMap emptyHash = new HashMap<Integer, ArrayList<Donation>>();
    assertEquals(emptyHash, testNonProfit.getCollection());
  }

  @Test
  void getContinuingMonthlyDonation() {
    ArrayList<MonthlyDonation> emptyList = new ArrayList<>();
    assertEquals(emptyList, testNonProfit.getMonthlyDonations());
  }

  @Test
  void addToMap() {
    testNonProfit.addToMap(testOneTimeDonation.getDate().getYear(), testOneTimeDonation);
    assertEquals(testOneTimeDonation, testNonProfit.getCollection().get(2021).get(0));
    // create and add new donations with different donation dates
    // second donation
    LocalDateTime secondDonationDate = LocalDateTime.of(2021, 12, 30, 15, 30);
    OneTimeDonation secondDonation = new OneTimeDonation(secondDonationDate, testAmount);
    testNonProfit.addToMap(secondDonation.getDate().getYear(), secondDonation);
    // third donation
    LocalDateTime thirdDonationDate = LocalDateTime.of(2022, 2, 15, 15, 30);
    OneTimeDonation thirdDonation = new OneTimeDonation(thirdDonationDate, testAmount);
    testNonProfit.addToMap(thirdDonation.getDate().getYear(), thirdDonation);
    // check the donations in the collection
    // third donation became index 0 element in value of key:2022 since it is the only donation made in 2022
    assertEquals(secondDonation, testNonProfit.getCollection().get(2021).get(1));
    assertEquals(thirdDonation, testNonProfit.getCollection().get(2022).get(0));
  }


  @Test
  void receiveOneTimeDonation() {
    testNonProfit.receiveDonation(testOneTimeDonation);
    int key = testOneTimeDonation.getDate().getYear(); // key would be 2021
    assertEquals(testOneTimeDonation, testNonProfit.getCollection().get(key).get(0));
  }

  @Test
  void receiveDonationMonthlyDonation() throws InvalidDateException {
    testNonProfit.receiveDonation(testMonthlyDonation1);
    int key = testOneTimeDonation.getDate().getYear(); // key would be 2021
    assertEquals(testMonthlyDonation1, testNonProfit.getCollection().get(key).get(0));
    assertEquals(testMonthlyDonation1, testNonProfit.getMonthlyDonations().get(0));
  }

  @Test
  void receiveDonationPledges() {
    // WHEN PROCESSING DATE IS NOT GIVEN
    // if processing date is not provided, the donation is added to the collection with null as key
    testNonProfit.receiveDonation(noProcessingPledges);
    assertEquals(noProcessingPledges, testNonProfit.getCollection().get(null).get(0));

    // WHEN PROCESSING DATE IS GIVEN
    HashMap newHash = new HashMap<Integer, ArrayList<Donation>>();
    ArrayList<MonthlyDonation> testMonthlyList = new ArrayList<>();
    NonProfit newNonProfit = new NonProfit("Blue Cross", newHash, testMonthlyList);
    LocalDateTime newProcessingDate = LocalDateTime.of(2028, 6, 1, 15, 30);
    Pledges newDonation = new Pledges(testCreationDate, 30000.00F, newProcessingDate);
    newNonProfit.receiveDonation(newDonation);
    assertEquals(newDonation, newNonProfit.getCollection().get(2028).get(0));
  }

  @Test
  void getThisYearMonthly() throws InvalidDateException {
    testNonProfit.receiveDonation(testMonthlyDonation1);
    testNonProfit.receiveDonation(testMonthlyDonation3);
    assertEquals(150, testNonProfit.getThisYearMonthly(testMonthlyDonation1, 2021));
    assertEquals(300, testNonProfit.getThisYearMonthly(testMonthlyDonation3, 2021));
    LocalDateTime newCancelDate = LocalDateTime.of(2022, 3, 5, 10, 00);
    testMonthlyDonation1.setCancellationDate(newCancelDate);
    assertEquals(75, testNonProfit.getThisYearMonthly(testMonthlyDonation1, 2022));
    LocalDateTime newCancelDate1 = LocalDateTime.of(2022, 11, 5, 10, 00);
    testMonthlyDonation3.setCancellationDate(newCancelDate1);
    assertEquals(250, testNonProfit.getThisYearMonthly(testMonthlyDonation3, 2022));
  }

  @Test
  void getTotalDonationForYear() throws InvalidDateException {
    // no donations were made
    assertEquals(0, testNonProfit.getTotalDonationForYear(2022));

    // when MonthlyDonations were made
    testNonProfit.receiveDonation(testMonthlyDonation1);
    testNonProfit.receiveDonation(testMonthlyDonation2);
    testNonProfit.receiveDonation(testMonthlyDonation3);
    assertEquals(900, testNonProfit.getTotalDonationForYear(2022));

    // when one time donation was made in the given year
    testNonProfit.receiveDonation(testOneTimeDonation1);
    assertEquals(1250, testNonProfit.getTotalDonationForYear(2022));

    // testMonthlyDonation's cancellation date is set to be on March.
    // Therefore, the total donation in 2022 will be 675 (300 each from testMonthlyDonation2 / testMonthlyDonation3 and 75 from testMonthlyDonation1)
    LocalDateTime newCancelDate = LocalDateTime.of(2022, 3, 5, 10, 00);
    testMonthlyDonation1.setCancellationDate(newCancelDate);
    assertEquals(1025, testNonProfit.getTotalDonationForYear(2022));

    // reset testMonthlyDonation1's cancellation date as 2025. It will have the same amount as the cancellation date was null.
    LocalDateTime futureCancelDate = LocalDateTime.of(2025, 3, 5, 10, 00);
    testMonthlyDonation1.setCancellationDate(futureCancelDate);
    assertEquals(1250, testNonProfit.getTotalDonationForYear(2022));
  }

  @Test
  void testRemoveOldPledges() {
    // testNonProfit should have noProcessingPledges only after removing testPledges
    testNonProfit.receiveDonation(testPledges);
    testNonProfit.receiveDonation(noProcessingPledges);
    testNonProfit.removeOldPledges(testPledges);
    // make a new NonProfit class and add noProcessingPledges only, and compare the collections of testNonProfit and newNonProfit.
    HashMap<Integer, ArrayList<Donation>> newCollection = new HashMap<>();
    NonProfit newNonProfit = new NonProfit("Red Cross", newCollection, testMonthlyList);
    newNonProfit.receiveDonation(noProcessingPledges);
    assertEquals(testNonProfit.getCollection(), newNonProfit.getCollection());
    testNonProfit.removeOldPledges(noProcessingPledges);

    // testNonProfit should have testPledges only after removing testPledges
    testNonProfit.receiveDonation(testPledges);
    testNonProfit.receiveDonation(noProcessingPledges);
    testNonProfit.removeOldPledges(noProcessingPledges);
    // make a new NonProfit class and add testPledges only, and compare the collections of testNonProfit and newNonProfit1.
    HashMap<Integer, ArrayList<Donation>> newCollection1 = new HashMap<>();
    NonProfit newNonProfit1 = new NonProfit("Red Cross", newCollection1, testMonthlyList);
    newNonProfit1.receiveDonation(testPledges);
    assertEquals(testNonProfit.getCollection(), newNonProfit1.getCollection());
    testNonProfit.removeOldPledges(testPledges);

    // test with other donations
    Pledges newPledges = new Pledges(LocalDateTime.of(2021, 10, 10, 10, 10), 350.00F, null);
    testNonProfit.receiveDonation(newPledges);
    testNonProfit.receiveDonation(testPledges);
    testNonProfit.receiveDonation(noProcessingPledges);
    testNonProfit.receiveDonation(testOneTimeDonation);
    testNonProfit.receiveDonation(testMonthlyDonation1);
    testNonProfit.receiveDonation(testMonthlyDonation2);
    testNonProfit.removeOldPledges(noProcessingPledges);
    testNonProfit.removeOldPledges(testPledges);
    testNonProfit.removeOldPledges(newPledges);
    HashMap<Integer, ArrayList<Donation>> newCollection2 = new HashMap<>();
    NonProfit newNonProfit2 = new NonProfit("Red Cross", newCollection2, testMonthlyList);
    newNonProfit2.receiveDonation(testOneTimeDonation);
    newNonProfit2.receiveDonation(testMonthlyDonation1);
    newNonProfit2.receiveDonation(testMonthlyDonation2);
    assertEquals(testNonProfit.getCollection(), newNonProfit2.getCollection());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testNonProfit.equals(testNonProfit));
  }

  @Test
  void testEquals_DifferentObject() {
    OneTimeDonation onetime = new OneTimeDonation(testCreationDate, 100.00F);
    assertFalse(testNonProfit.equals(onetime));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testNonProfit.equals(null));
  }

  @Test
  void testEquals_DifferentOrganizationName() {
    NonProfit newNonProfit = new NonProfit("Blue Cross", testCollection, testMonthlyList);
    assertFalse(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testEquals_DifferentCollection() {
    HashMap<Integer, ArrayList<Donation>> newCollection = new HashMap<>();
    ArrayList<Donation> newArray = new ArrayList();
    newArray.add(testOneTimeDonation);
    newCollection.put(2021, newArray);
    NonProfit newNonProfit = new NonProfit("Blue Cross", newCollection, testMonthlyList);
    assertFalse(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testEquals_DifferentMonthlyDonation() {
    ArrayList<MonthlyDonation> newMonthly = new ArrayList<>();
    newMonthly.add(testMonthlyDonation3);
    NonProfit newNonProfit = new NonProfit("Blue Cross", testCollection, newMonthly);
    assertFalse(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() {
    String newName = "Red Cross";
    HashMap<Integer, ArrayList<Donation>> newCollection = new HashMap<>();
    ArrayList<MonthlyDonation> newMonthly = new ArrayList<>();
    NonProfit newNonProfit = new NonProfit(newName, newCollection, newMonthly);
    assertTrue(testNonProfit.equals(newNonProfit));
  }

  @Test
  void testHashCode() {
    String newName = "Red Cross";
    HashMap<Integer, ArrayList<Donation>> newCollection = new HashMap<>();
    ArrayList<MonthlyDonation> newMonthly = new ArrayList<>();
    NonProfit newNonProfit = new NonProfit(newName, newCollection, newMonthly);
    assertTrue(testNonProfit.hashCode() == newNonProfit.hashCode());
  }

  @Test
  void testToString() {
    String expectedNonProfit = "NonProfit{" +
        "OrganizationName='" + "Red Cross" + '\'' +
        ", collection=" + "{}" +
        ", continuingMonthlyDonation=" + "[]" +
        '}';
    assertEquals(expectedNonProfit, testNonProfit.toString());
  }
}