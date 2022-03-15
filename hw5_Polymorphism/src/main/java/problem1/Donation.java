package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Donation.java
 * <p>
 * Donation class stores information of each Donation. It is super class of MonthlyDonation,
 * OneTimeDonation, Pledges.
 */
public abstract class Donation {

  protected LocalDateTime date;
  protected float amount;

  /**
   * Constructor of Donation
   *
   * @param date   - the date that the donation was made, as LocalTimeDate
   * @param amount - the amount donated, as float
   */
  public Donation(LocalDateTime date, float amount) {
    this.date = date;
    this.amount = amount;
  }

  /**
   * getter for date
   *
   * @return the date of the donation made
   */
  public LocalDateTime getDate() {
    return date;
  }

  /**
   * getter for amount
   *
   * @return the amount of the donation made
   */
  public float getAmount() {
    return amount;
  }

  /**
   * equal method of Donation
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Donation donation = (Donation) o;
    return Float.compare(donation.amount, amount) == 0 && Objects.equals(date,
        donation.date);
  }

  /**
   * hashCode method of Donation
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, amount);
  }

  /**
   * toString method of Donation
   */
  @Override
  public String toString() {
    return "Donation{" +
        "date=" + date +
        ", amount=" + amount +
        '}';
  }
}
