package problem1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 MonthlyDonation.java
 * <p>
 * MonthlyDonation class stores information of Monthly Donation. The cancellation date for a monthly
 * donation is set as null at the time created. It can be set any time in the future. Inherits
 * Donation class.
 */
public class MonthlyDonation extends Donation {

  private LocalDateTime cancellationDate;

  /**
   * Constructor of MonthlyDonation
   *
   * @param date   - the date that the donation was made, as LocalTimeDate
   * @param amount - the amount donated, as float
   */
  public MonthlyDonation(LocalDateTime date, float amount) {
    super(date, amount);
    this.cancellationDate = null;
  }

  /**
   * Getter for CancellationDate
   *
   * @return the date of cancellation date
   */
  public LocalDateTime getCancellationDate() {
    return cancellationDate;
  }

  /**
   * Setter for CancellationDate, encoded as LocalDateTime
   *
   * @param cancellationDate - set a new cancellation date with LocalTimeDate datatype value
   * @throws InvalidDateException - throws InvalidDateException when the given date is before the
   *                              donation was made.
   */
  public void setCancellationDate(LocalDateTime cancellationDate) throws InvalidDateException {
    LocalDateTime cancellationTime = cancellationDate;
    if (cancellationDate.isBefore(super.date)) {
      throw new InvalidDateException("The cancellation date cannot be before donation date");
    }
    this.cancellationDate = cancellationTime;
  }

  /**
   * equals method for MonthlyDonation
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(cancellationDate, that.cancellationDate);
  }

  /**
   * hashCode method for MonthlyDonation
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationDate);
  }

  /**
   * toString method for MonthlyDonation
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "date=" + date +
        ", amount=" + amount +
        ", cancellationDate=" + cancellationDate +
        '}';
  }
}
