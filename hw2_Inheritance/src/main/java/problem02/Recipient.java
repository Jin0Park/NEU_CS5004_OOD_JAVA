package problem02;

import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw2 Recipient.java
 *
 * Recipient stores information of mail item's recipient. Information contains the recipient's
 * firstname, lastname, email address.
 */
public class Recipient {

  protected String firstname;
  protected String lastname;
  protected String emailAddress;

  /**
   * Constructor of Recipient class
   *
   * @param firstname     - representing firstname of recipient, as String
   * @param lastname      - representing lastname of recipient, as String
   * @param emailAddress- representing email address of recipient, as String
   */
  public Recipient(String firstname, String lastname, String emailAddress) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter for firstname
   *
   * @return the firstname of the recipient, as String
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Setter for firstname
   *
   * @param firstname - firstname of recipient, encoded as String
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Getter for lastname
   *
   * @return the lastname of the recipient, as String
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Setter for lastname
   *
   * @param lastname - lastname of recipient, encoded as String
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Getter for emailAddress
   *
   * @return the email address of the recipient, as String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * Setter for emailAddress
   *
   * @param emailAddress - email address of recipient, encoded as String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(firstname, recipient.firstname) && Objects.equals(
        lastname, recipient.lastname) && Objects.equals(emailAddress,
        recipient.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, emailAddress);
  }

  @Override
  public String toString() {
    return "Recipient{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
