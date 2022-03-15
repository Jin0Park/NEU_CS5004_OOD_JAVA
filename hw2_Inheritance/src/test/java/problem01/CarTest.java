package problem01;

import static org.junit.jupiter.api.Assertions.*;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem01.Car;

class CarTest {

  private Car testCar;
  private Car bookedCar;
  private int expectedMaxOccupancy;
  private Double expectedDailyPrice;
  private boolean expectedSpecialDriverLicense;
  private boolean expectedAllowDifferentLoc;
  private int expectedNumOfBookedDays;

  @BeforeEach
  void setUp() throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    testCar = new Car(16.00, 0);
    bookedCar = new Car(16.00, 5);
    expectedMaxOccupancy = 5;
    expectedDailyPrice = 16.0;
    expectedSpecialDriverLicense = false;
    expectedAllowDifferentLoc = true;
    expectedNumOfBookedDays = 0;
    // exception case where daily price input is below zero
    Exception IllegalDailyPriceException = assertThrows(Exception.class,
        () -> testCar = new Car(-20.0, 5));
    assertEquals("Invalid Input!", IllegalDailyPriceException.getMessage());
    // exception case where daily price input is below zero
    Exception IllegalNumberOfDaysException = assertThrows(Exception.class,
        () -> testCar = new Car(20.0, -5));
    assertEquals("Invalid Input!", IllegalNumberOfDaysException.getMessage());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(expectedMaxOccupancy, testCar.getMaxOccupancy());
  }

  @Test
  void getDailyPrice() {
    assertEquals(expectedDailyPrice, testCar.getDailyPrice());
  }

  @Test
  void getNeedSpecialDriverLicense() {
    assertEquals(expectedSpecialDriverLicense, testCar.getNeedSpecialDriverLicense());
  }

  @Test
  void isAllowDifferentLoc() {
    assertEquals(expectedAllowDifferentLoc, testCar.isAllowDifferentLoc());
  }

  @Test
  void getNumOfBookedDays() {
    assertEquals(expectedNumOfBookedDays, testCar.getNumOfBookedDays());
  }

  @Test
  void isAvailable() {
    assertTrue(testCar.isAvailable());
    assertFalse(bookedCar.isAvailable());
  }

  @Test
  void bookVehicle() throws IllegalNumberOfDaysException {
    assertEquals(0, testCar.getNumOfBookedDays());
    assertTrue(testCar.bookVehicle(5, 5, "Seattle", "Bellevue", false));
    assertEquals(5, testCar.getNumOfBookedDays());
    // when the number of passengers is over maxOccupancy for car
    assertFalse(testCar.bookVehicle(5, 8, "Seattle", "Bellevue", false));
    // when the number of passengers is lower than 0
    assertFalse(testCar.bookVehicle(-1, 8, "Seattle", "Bellevue", false));
    // when the car is booked
    testCar.setNumOfBookedDays(5);
    assertFalse(testCar.bookVehicle(5, 5, "Seattle", "Bellevue", false));
    assertFalse(bookedCar.bookVehicle(5, 5, "Seattle", "Bellevue", false));
  }
}