package problem01;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem01.Van;

class VanTest {

  private Van testVan;
  private Van bookedVan;
  private int expectedMaxOccupancy;
  private Double expectedDailyPrice;
  private boolean expectedSpecialDriverLicense;
  private boolean expectedAllowDifferentLoc;
  private int expectedNumOfBookedDays;


  @BeforeEach
  void setUp() throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    testVan = new Van(50.00, 0);
    bookedVan = new Van(50.00, 3);
    expectedMaxOccupancy = 8;
    expectedDailyPrice = 50.0;
    expectedSpecialDriverLicense = false;
    expectedAllowDifferentLoc = false;
    expectedNumOfBookedDays = 0;

    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testVan = new Van(-20.0, 5));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
    // exception case where daily price input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testVan = new Van(20.0, -5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(expectedMaxOccupancy, testVan.getMaxOccupancy());
  }

  @Test
  void getDailyPrice() {
    assertEquals(expectedDailyPrice, testVan.getDailyPrice());
  }

  @Test
  void isSpecialDriverLicense() {
    assertEquals(expectedSpecialDriverLicense, testVan.getNeedSpecialDriverLicense());
  }

  @Test
  void isAllowDifferentLoc() {
    assertEquals(expectedAllowDifferentLoc, testVan.isAllowDifferentLoc());
  }

  @Test
  void getNumOfBookedDays() {
    assertEquals(expectedNumOfBookedDays, testVan.getNumOfBookedDays());
  }

  @Test
  void isAvailable() {
    assertTrue(testVan.isAvailable());
    assertFalse(bookedVan.isAvailable());
  }

  @Test
  void bookVehicle() throws IllegalNumberOfDaysException {
    assertEquals(0, testVan.getNumOfBookedDays());
    assertTrue(testVan.bookVehicle(8, 8, "Seattle", "Seattle", false));
    assertEquals(8, testVan.getNumOfBookedDays());
    // single invalid input cases
    // when the number of passengers are over 8
    assertFalse(testVan.bookVehicle(8, 15, "Seattle", "Seattle", false));
    // when the number of passengers is lower than 0
    assertFalse(testVan.bookVehicle(-1, 15, "Seattle", "Seattle", false));
    // when the pickup location and dropoff location are different
    assertFalse(testVan.bookVehicle(8, 8, "Seattle", "Bellevue", false));
    // when the Van is not available
    testVan.setNumOfBookedDays(5);
    assertFalse(testVan.bookVehicle(8, 8, "Seattle", "Seattle", false));
    assertFalse(bookedVan.bookVehicle(8, 8, "Seattle", "Seattle", false));

    // multiple invalid inputs cases
    // when the number of passengers exceeds 8 and pickup/dropoff locations are different
    assertFalse(testVan.bookVehicle(8, 15, "Seattle", "Bellevue", false));
    // when the number of passengers exceeds 8 and pickup/dropoff locations are different
    assertFalse(testVan.bookVehicle(8, 15, "Seattle", "Bellevue", false));
  }
}