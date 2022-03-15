package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pledges extends Donation {

  /**
   * CS5004 Spring2022 Jin Young Park hw5 Pledges.java
   * <p>
   * Pledges class stores information of Pledge Donation. The processing date of a pledge donation
   * may or may not be set. Once set, the donation will be processed on the processing date.
   * Inherits Donation class.
   */
  protected LocalDateTime processingDate;

  /**
   * Constructor of Pledges class
   *
   * @param date           - the date that the donation was made, as LocalTimeDate
   * @param amount         - the amount donated, as float
   * @param processingDate - the date that the donation is processing
   */
  public Pledges(LocalDateTime date, float amount, LocalDateTime processingDate) {
    super(date, amount);
    this.processingDate = processingDate;
  }

  /**
   * getter of processingDate
   *
   * @return the processing date of the donation
   */
  protected LocalDateTime getProcessingDate() {
    return this.processingDate;
  }

  /**
   * setter of processingDate
   *
   * @param date - the date that the donation is getting processed
   * @throws InvalidDateException - throws exception when the processing date is before the creation
   *                              date.
   */
  protected void setProcessingDate(LocalDateTime date) throws InvalidDateException {
    if (date.isBefore(super.date)) {
      throw new InvalidDateException("Processing Date cannot be before creation date");
    }
    this.processingDate = date;
  }

  /**
   * removes the processing date. processingDate becomes null.
   */
  protected void removeProcessingDate() {
    this.processingDate = null;
  }

  /**
   * equals method for Pledges class
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
    Pledges pledges = (Pledges) o;
    return Objects.equals(processingDate, pledges.processingDate);
  }

  /**
   * hashcode method for Pledges class
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processingDate);
  }

  /**
   * toString method for Pledges class
   */
  @Override
  public String toString() {
    return "Pledges{" +
        "date=" + date +
        ", amount=" + amount +
        ", processingDate=" + processingDate +
        '}';
  }
}
