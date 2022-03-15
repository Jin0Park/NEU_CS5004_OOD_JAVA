package problem1;

import java.time.LocalDateTime;

/**
 * CS5004 Spring2022 Jin Young Park hw5 OneTimeDonation.java
 * <p>
 * OneTimeDonation class stores information of One Time Donation. Inherits Donation class.
 */
public class OneTimeDonation extends Donation {

  /**
   * Constructor of OneTimeDonation class
   *
   * @param date   - the date that the donation was made, as LocalTimeDate
   * @param amount - the amount donated, as float
   */
  public OneTimeDonation(LocalDateTime date, float amount) {
    super(date, amount);
  }
}
