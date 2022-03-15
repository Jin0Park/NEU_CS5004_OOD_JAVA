package problem01;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;

/**
 * CS5004 Spring2022 Jin Young Park hw2 Van.java
 *
 * Van is a child class of Vehicle and inherits the fields from Vehicle class. The maximum
 * occupancy, whether it needs special driver's license, and whether it allows different pickup and
 * dropoff locations are set as constant.
 */
public class Van extends Vehicle {

  private static final int maxOccupancy = 8;
  private static final boolean needSpecialDL = false;
  private static final boolean allowDifferentLoc = false;

  /**
   * Constructor of Van class
   *
   * @param dailyPrice      - representing the daily price for renting the vehicle, as Double
   * @param numOfBookedDays - representing the number of days that the vehicle is booked, as
   *                        Integer
   * @throws IllegalDailyPriceException - If the inputs of the daily price is below 0, then
   *                   it throws exception since it is invalid input
   * @throws IllegalNumberOfDaysException - If the inputs of the number of days is below 0, then
   *                   it throws exception since it is invalid input   */
  public Van(Double dailyPrice, int numOfBookedDays)
      throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    super(maxOccupancy, dailyPrice, needSpecialDL, allowDifferentLoc, numOfBookedDays);
  }
}
