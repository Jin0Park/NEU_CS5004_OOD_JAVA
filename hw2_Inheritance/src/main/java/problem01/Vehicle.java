package problem01;

import hw2exceptions.IllegalDailyPriceException;
import hw2exceptions.IllegalNumberOfDaysException;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw2 Vehicle.java
 *
 * Vehicle is parent class of Car, LuxuryCar, Truck, and Van. It stores information about the
 * vehicle in terms of vehicle reservation system. All vehicles have a maximum occupancy, daily
 * price, whether it requires a special Driver's License, whether it can be picked up and dropped
 * off at different locations, and the number of days the vehicle is booked.
 */
public class Vehicle {

  protected int maxOccupancy;
  protected Double dailyPrice;
  protected boolean needSpecialDriverLicense;
  protected boolean allowDifferentLoc;
  protected int numOfBookedDays;

  /**
   * Constructor of Vehicle class
   *
   * @param maxOccupancy             - representing the maximum occupancy of a vehicle, as Integer
   * @param dailyPrice               - representing the daily price for renting the vehicle, as
   *                                 Double
   * @param needSpecialDriverLicense - representing whether it requires special driver's license to
   *                                 drive this vehicle, as Boolean
   * @param allowDifferentLoc        - representing whether the vehicle can be picked up and dropped
   *                                 off at different locations, as Boolean
   * @param numOfBookedDays          - representing the number of days that the vehicle is booked,
   *                                 as Integer
   * @throws IllegalDailyPriceException   - If the inputs of the daily price is below 0, then it
   *                                      throws exception since it is invalid input
   * @throws IllegalNumberOfDaysException - If the inputs of the number of days is below 0, then it
   *                                      throws exception since it is invalid input
   */

  public Vehicle(int maxOccupancy, Double dailyPrice, boolean needSpecialDriverLicense,
      boolean allowDifferentLoc, int numOfBookedDays)
      throws IllegalDailyPriceException, IllegalNumberOfDaysException {
    this.maxOccupancy = maxOccupancy;
    if (dailyPrice >= 0) {
      this.dailyPrice = dailyPrice;
    } else {
      throw new IllegalDailyPriceException("Invalid Input!");
    }
    this.needSpecialDriverLicense = needSpecialDriverLicense;
    this.allowDifferentLoc = allowDifferentLoc;
    if (numOfBookedDays >= 0) {
      this.numOfBookedDays = numOfBookedDays;
    } else {
      throw new IllegalNumberOfDaysException("Invalid Input!");
    }
  }

  /**
   * Getter for maxOccupancy
   *
   * @return the maximum occupancy of the vehicle, as Integer
   */
  public int getMaxOccupancy() {
    return maxOccupancy;
  }

  /**
   * Getter for dailyPrice
   *
   * @return the daily price for booking the vehicle, as Double
   */
  public Double getDailyPrice() {
    return dailyPrice;
  }

  /**
   * Getter for needSpecialDriverLicense
   *
   * @return whether it requires special driver's license to book the vehicle, as Boolean
   */
  public boolean getNeedSpecialDriverLicense() {
    return needSpecialDriverLicense;
  }

  /**
   * Getter for allowDifferentLoc
   *
   * @return whether the vehicle can be picked up and dropped off at different locations, as Boolean
   */
  public boolean isAllowDifferentLoc() {
    return allowDifferentLoc;
  }

  /**
   * Getter for numOfBookedDays
   *
   * @return the number of days the vehicle is booked, as Integer
   */
  public int getNumOfBookedDays() {
    return numOfBookedDays;
  }

  /**
   * Setter for maxOccupancy
   *
   * @param maxOccupancy - maximum occupancy of the vehicle, encoded as Integer
   */
  public void setMaxOccupancy(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  /**
   * Setter for dailyPrice
   *
   * @param dailyPrice - the daily price to book the vehicle, encoded as Double
   * @throws IllegalDailyPriceException - when input for daily price is below 0.
   */
  public void setDailyPrice(Double dailyPrice) throws IllegalDailyPriceException {
    if (dailyPrice >= 0) {
      this.dailyPrice = dailyPrice;
    } else {
      throw new IllegalDailyPriceException("Invalid Input!");
    }
  }

  /**
   * Setter for needSpecialDriverLicense
   *
   * @param needSpecialDriverLicense - whether it requires a special driver's license to book,
   *                                 encoded as Boolean
   */
  public void setNeedSpecialDriverLicense(boolean needSpecialDriverLicense) {
    this.needSpecialDriverLicense = needSpecialDriverLicense;
  }

  /**
   * Setter for allowDifferenceLoc
   *
   * @param allowDifferentLoc - whether the vehicle can be picked up and dropped off at different
   *                          locations
   */
  public void setAllowDifferentLoc(boolean allowDifferentLoc) {
    this.allowDifferentLoc = allowDifferentLoc;
  }

  /**
   * Setter for numOfBookedDays
   *
   * @param numOfBookedDays - the number of days the vehicle is booked, encoded as Integer
   * @throws IllegalNumberOfDaysException - if the input for numOfBookedDays is below 0, then throws
   *                                      exception
   */
  public void setNumOfBookedDays(int numOfBookedDays) throws IllegalNumberOfDaysException {
    if (numOfBookedDays >= 0) {
      this.numOfBookedDays = numOfBookedDays;
    } else {
      throw new IllegalNumberOfDaysException("Invalid Input!");
    }
  }

  /**
   * Checks if the vehicle is available to book
   *
   * @return true if the vehicle is not booked, false if it is booked.
   */
  public boolean isAvailable() {
    if (this.numOfBookedDays > 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Books the vehicle after checking multiple conditions that the vehicle requires.
   *
   * @param numOfDaysWanted - the number of days the person wants to book the vehicle for, as
   *                        Integer
   * @param numOfPassengers - the number of passengers that will be in the vehicle, as Integer
   * @param pickUpLoc       - the location the person will pick up the car, as String
   * @param dropOffLoc      - the location the person will drop off the car, as String
   * @param haveSpecialDL   - whether the person has a special driver's license, as boolean
   * @return true if the vehicle is booked, false if the vehicle could not be booked
   * @throws IllegalNumberOfDaysException if the given number of days wanted is below 0, it throws
   *                                      exception.
   */
  public boolean bookVehicle(int numOfDaysWanted, int numOfPassengers, String pickUpLoc,
      String dropOffLoc, boolean haveSpecialDL) throws IllegalNumberOfDaysException {
    boolean canBook = true;
    if (!this.isAvailable() || numOfPassengers > this.maxOccupancy || numOfPassengers < 0) {
      canBook = false;
    }
    if (!this.allowDifferentLoc && (pickUpLoc != dropOffLoc)) {
      canBook = false;
    }
    if (this.needSpecialDriverLicense && !haveSpecialDL) {
      canBook = false;
    }

    if (canBook == true) {
      //set the vehicle's number of booked days to the given number of days wanted value
      setNumOfBookedDays(numOfDaysWanted);
    }
    return canBook;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return maxOccupancy == vehicle.maxOccupancy
        && needSpecialDriverLicense == vehicle.needSpecialDriverLicense
        && allowDifferentLoc == vehicle.allowDifferentLoc
        && numOfBookedDays == vehicle.numOfBookedDays && Objects.equals(dailyPrice,
        vehicle.dailyPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxOccupancy, dailyPrice, needSpecialDriverLicense, allowDifferentLoc,
        numOfBookedDays);
  }

  @Override
  public String toString() {
    return "problem01.Vehicle{" +
        "maxOccupancy=" + maxOccupancy +
        ", dailyPrice=" + dailyPrice +
        ", specialDriverLicense=" + needSpecialDriverLicense +
        ", allowDifferentLoc=" + allowDifferentLoc +
        ", numOfBookedDays=" + numOfBookedDays +
        '}';
  }
}
