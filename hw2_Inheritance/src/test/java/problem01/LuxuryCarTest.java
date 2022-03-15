package problem01;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem01.LuxuryCar;

class LuxuryCarTest {

  private LuxuryCar testLuxuryCar;
  private LuxuryCar bookedLuxuryCar;
  private int expectedMaxOccupancy;
  private Double expectedDailyPrice;
  private boolean expectedSpecialDriverLicense;
  private boolean expectedAllowDifferentLoc;
  private int expectedNumOfBookedDays;

  @BeforeEach
  void setUp() throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    testLuxuryCar = new LuxuryCar(100.00, 0);
    bookedLuxuryCar = new LuxuryCar(100.00, 5);
    expectedMaxOccupancy = 4;
    expectedDailyPrice = 100.0;
    expectedSpecialDriverLicense = false;
    expectedAllowDifferentLoc = false;
    expectedNumOfBookedDays = 0;
    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testLuxuryCar = new LuxuryCar(-20.0, 5));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
    // exception case where daily price input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testLuxuryCar = new LuxuryCar(20.0, -5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(expectedMaxOccupancy, testLuxuryCar.getMaxOccupancy());
  }

  @Test
  void getDailyPrice() {
    assertEquals(expectedDailyPrice, testLuxuryCar.getDailyPrice());
  }

  @Test
  void getNeedSpecialDriverLicense() {
    assertEquals(expectedSpecialDriverLicense, testLuxuryCar.getNeedSpecialDriverLicense());
  }

  @Test
  void isAllowDifferentLoc() {
    assertEquals(expectedAllowDifferentLoc, testLuxuryCar.isAllowDifferentLoc());
  }

  @Test
  void getNumOfBookedDays() {
    assertEquals(expectedNumOfBookedDays, testLuxuryCar.getNumOfBookedDays());
  }

  @Test
  void isAvailable() {
    assertTrue(testLuxuryCar.isAvailable());
    assertFalse(bookedLuxuryCar.isAvailable());
  }

  @Test
  void bookVehicle() throws IllegalNumberOfDaysException {
    assertEquals(0, testLuxuryCar.getNumOfBookedDays());
    assertTrue(testLuxuryCar.bookVehicle(4, 4, "Seattle", "Seattle", false));
    assertEquals(4, testLuxuryCar.getNumOfBookedDays());
    // when the number of passengers are over 4
    assertFalse(testLuxuryCar.bookVehicle(4, 5, "Seattle", "Seattle", false));
    // when the number of passengers is lower than 0
    assertFalse(testLuxuryCar.bookVehicle(-1, 5, "Seattle", "Seattle", false));
    // when the LuxuryCar is booked
    testLuxuryCar.setNumOfBookedDays(5);
    assertFalse(testLuxuryCar.bookVehicle(4, 4, "Seattle", "Seattle", false));
    assertFalse(bookedLuxuryCar.bookVehicle(4, 4, "Seattle", "Seattle", false));
    // when the pickup location and dropoff location are different
    assertFalse(testLuxuryCar.bookVehicle(4, 4, "Seattle", "Bellevue", false));
  }
}