package problem01;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem01.Truck;

class TruckTest {

  private Truck testTruck;
  private Truck bookedTruck;
  private int expectedMaxOccupancy;
  private Double expectedDailyPrice;
  private boolean expectedSpecialDriverLicense;
  private boolean expectedAllowDifferentLoc;
  private int expectedNumOfBookedDays;

  @BeforeEach
  void setUp() throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    testTruck = new Truck(35.0, 0);
    bookedTruck = new Truck(35.0, 3);
    expectedMaxOccupancy = 2;
    expectedDailyPrice = 35.0;
    expectedSpecialDriverLicense = true;
    expectedAllowDifferentLoc = false;
    expectedNumOfBookedDays = 0;

    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testTruck = new Truck(-20.0, 5));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
    // exception case where daily price input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testTruck = new Truck(20.0, -5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(expectedMaxOccupancy, testTruck.getMaxOccupancy());
  }

  @Test
  void getDailyPrice() {
    assertEquals(expectedDailyPrice, testTruck.getDailyPrice());
  }

  @Test
  void getNeedSpecialDriverLicense() {
    assertEquals(expectedSpecialDriverLicense, testTruck.getNeedSpecialDriverLicense());
  }

  @Test
  void isAllowDifferentLoc() {
    assertEquals(expectedAllowDifferentLoc, testTruck.isAllowDifferentLoc());
  }

  @Test
  void getNumOfBookedDays() {
    assertEquals(expectedNumOfBookedDays, testTruck.getNumOfBookedDays());
  }

  @Test
  void isAvailable() {
    assertTrue(testTruck.isAvailable());
    assertFalse(bookedTruck.isAvailable());
  }

  @Test
  void bookVehicle() throws IllegalNumberOfDaysException {
    assertEquals(0, testTruck.getNumOfBookedDays());
    assertTrue(testTruck.bookVehicle(10, 2, "Seattle", "Seattle", true));
    assertEquals(10, testTruck.getNumOfBookedDays());
    // single invalid input cases
    // when the number of passengers are over 2
    assertFalse(testTruck.bookVehicle(10, 3, "Seattle", "Seattle", true));
    // when the number of passengers is lower than 0
    assertFalse(testTruck.bookVehicle(-1, 3, "Seattle", "Seattle", true));
    // when the Truck is booked
    testTruck.setNumOfBookedDays(5);
    assertFalse(testTruck.bookVehicle(10, 2, "Seattle", "Seattle", true));
    assertFalse(bookedTruck.bookVehicle(10, 2, "Seattle", "Seattle", true));
    // when the pickup location and dropoff location are different

    // multiple invalid inputs cases
    testTruck.setNumOfBookedDays(0);
    assertFalse(testTruck.bookVehicle(10, 2, "Seattle", "Bellevue", true));
    // when the renter does not have special driver's license
    assertFalse(testTruck.bookVehicle(10, 2, "Seattle", "Seattle", false));
    // when the number of passengers exceeds 2 and pickup / dropoff locations are different
    assertFalse(testTruck.bookVehicle(10, 5, "Seattle", "Bellevue", true));
    // when the number of passengers exceeds 2 and pickup / dropoff locations are different and no special driver's license
    assertFalse(testTruck.bookVehicle(10, 5, "Seattle", "Bellevue", false));
    // when the car is not available and the number of passengers exceeds 2 and pickup / dropoff locations are different and no special driver's license
    testTruck.setNumOfBookedDays(5);
    assertFalse(testTruck.bookVehicle(10, 5, "Seattle", "Bellevue", false));
  }
}