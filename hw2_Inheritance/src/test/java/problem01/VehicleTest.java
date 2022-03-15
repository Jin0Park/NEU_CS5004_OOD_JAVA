package problem01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hw2exceptions.IllegalNumberOfDaysException;
import hw2exceptions.IllegalDailyPriceException;

class VehicleTest {

  private int expectedMaxOccupancy;
  private Double expectedDailyPrice;
  private boolean expectedNeedSpecialDriverLicense;
  private boolean expectedAllowDifferentLoc;
  private int expectedNumOfBookedDays;
  private Vehicle testVehicle;
  private Vehicle bookedVehicle;

  @BeforeEach
  void setUp() throws Exception {
    testVehicle = new Vehicle(5, 18.00, false, true, 0);
    bookedVehicle = new Vehicle(5, 18.00, false, true, 5);
    expectedMaxOccupancy = 5;
    expectedDailyPrice = 18.00;
    expectedNeedSpecialDriverLicense = false;
    expectedAllowDifferentLoc = true;
    expectedNumOfBookedDays = 0;

    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testVehicle = new Vehicle(5, -20.00, false, true, 5));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
    // exception case where number of booked days input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testVehicle = new Vehicle(5, 20.00, false, true, -5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(expectedMaxOccupancy, testVehicle.getMaxOccupancy());
  }

  @Test
  void getDailyPrice() {
    assertEquals(expectedDailyPrice, testVehicle.getDailyPrice());
  }

  @Test
  void getNeedSpecialDriverLicense() {
    assertEquals(expectedNeedSpecialDriverLicense, testVehicle.getNeedSpecialDriverLicense());
  }

  @Test
  void isAllowDifferentLoc() {
    assertEquals(expectedAllowDifferentLoc, testVehicle.isAllowDifferentLoc());
  }

  @Test
  void getNumOfBookedDays() {
    assertEquals(expectedNumOfBookedDays, testVehicle.getNumOfBookedDays());
  }

  @Test
  void setMaxOccupancy() {
    testVehicle.setMaxOccupancy(8);
    assertEquals(8, testVehicle.getMaxOccupancy());
  }

  @Test
  void setDailyPrice() throws Exception {
    testVehicle.setDailyPrice(100.00);
    assertEquals(100.00, testVehicle.getDailyPrice());

    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testVehicle.setDailyPrice(-100.00));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
  }

  @Test
  void setNeedSpecialDriverLicense() {
    testVehicle.setNeedSpecialDriverLicense(true);
    assertEquals(true, testVehicle.getNeedSpecialDriverLicense());
  }

  @Test
  void setAllowDifferentLoc() {
    testVehicle.setAllowDifferentLoc(false);
    assertEquals(false, testVehicle.isAllowDifferentLoc());
  }

  @Test
  void setNumOfBookedDays() throws Exception {
    testVehicle.setNumOfBookedDays(100);
    assertEquals(100, testVehicle.getNumOfBookedDays());
    // exception case where number of booked days input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testVehicle.setNumOfBookedDays(-5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void isAvailable() {
    assertTrue(testVehicle.isAvailable());
    assertFalse(bookedVehicle.isAvailable());
  }

  @Test
  void bookVehicle() throws Exception {
    assertEquals(true, testVehicle.bookVehicle(5, 4, "Seattle", "Bellevue", false));
    // when the vehicle is already booked
    assertEquals(false, testVehicle.bookVehicle(5, 4, "Seattle", "Bellevue", false));
    testVehicle.setNumOfBookedDays(0);
    // when the number of passengers is over than maximum occupancy of the vehicle
    assertEquals(false, testVehicle.bookVehicle(5, 8, "Seattle", "Bellevue", false));
    // when the number of passengers is below 0
    assertEquals(false, testVehicle.bookVehicle(5, -8, "Seattle", "Bellevue", false));

    // exception case where number of booked days input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testVehicle.bookVehicle(-5, 4, "Seattle", "Bellevue", false));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testVehicle.equals(testVehicle));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testVehicle.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() throws Exception {
    Car testCar = new Car(18.00, 8);
    assertFalse(testVehicle.equals(testCar));
  }

  @Test
  void testEquals_DifferentInheritedFields() throws Exception {
    Vehicle newTestVehicle = new Vehicle(7, 10.00, true, false, 3);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_SameFieldsOverall() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 18.00, false, true, 0);
    assertTrue(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_DifferentMaxOccupancy() throws Exception {
    Vehicle newTestVehicle = new Vehicle(8, 18.00, false, true, 0);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_DifferentDailyPrice() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 5.00, false, true, 5);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_DifferentSpecialDriverLicense() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 18.00, true, true, 0);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_DifferentAllowDifferentLoc() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 18.00, false, false, 0);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testEquals_DifferentNumberOfBookedDays() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 18.00, false, true, 120);
    assertFalse(testVehicle.equals(newTestVehicle));
  }

  @Test
  void testHashCode() throws Exception {
    Vehicle newTestVehicle = new Vehicle(5, 18.00, false, true, 0);
    assertTrue(testVehicle.hashCode() == newTestVehicle.hashCode());
  }

  @Test
  void testToString() {
    String result = "problem01.Vehicle{" +
        "maxOccupancy=" + "5" +
        ", dailyPrice=" + "18.0" +
        ", specialDriverLicense=" + "false" +
        ", allowDifferentLoc=" + "true" +
        ", numOfBookedDays=" + "0" +
        '}';
    assertEquals(testVehicle.toString(), result);
  }
}