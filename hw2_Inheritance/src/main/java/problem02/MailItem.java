package problem02;

import java.util.Objects;
import hw2exceptions.IllegalLengthException;

/**
 * CS5004 Spring2022 Jin Young Park hw2 MailItem.java
 *
 * MailItem stores information of the mail. The information includes its width, height, depth, and
 * the recipient information of the mail.
 */
public class MailItem {

  protected int width;
  protected int height;
  protected int depth;
  protected Recipient currentRecipient;

  /**
   * Constructor of MailItem
   *
   * @param width            - representing the width of the mail item, as Integer
   * @param height           - representing the height of the mail item, as Integer
   * @param depth            - representing the depth of the mail item, as Integer
   * @param currentRecipient - representing the recipient of the mail item, from Recipient class
   * @throws IllegalLengthException -  if either width or height or depth is lower than 0
   */
  public MailItem(int width, int height, int depth, Recipient currentRecipient)
      throws IllegalLengthException {
    if (width >= 1) {
      this.width = width;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }

    if (height >= 1) {
      this.height = height;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }

    if (depth >= 1) {
      this.depth = depth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
    this.currentRecipient = currentRecipient;
  }

  /**
   * Getter for width
   *
   * @return the width of the mail item, as Integer
   */
  public int getWidth() {
    return width;
  }

  /**
   * Setter for width
   *
   * @param width - the width of the mail item, encoded as Integer
   * @throws IllegalLengthException - when width input is lower than 0
   */
  public void setWidth(int width) throws IllegalLengthException {
    if (width >= 1) {
      this.width = width;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for height
   *
   * @return the height of the mail item, as Integer
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter for width
   *
   * @param height - the height of the mail item, encoded as Integer
   * @throws IllegalLengthException - when height input is lower than 0
   */
  public void setHeight(int height) throws IllegalLengthException {
    if (height >= 1) {
      this.height = height;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for depth
   *
   * @return the depth of the mail item, as Integer
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Setter for width
   *
   * @param depth - the depth of the mail item, encoded as Integer
   * @throws IllegalLengthException - when depth input is lower than 0
   */
  public void setDepth(int depth) throws IllegalLengthException {
    if (depth >= 1) {
      this.depth = depth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for recipient
   *
   * @return the recipient information from Recipient class
   */
  public Recipient getCurrentRecipient() {
    return currentRecipient;
  }

  /**
   * Setter for CurrentRecipient
   *
   * @param currentRecipient - the recipient of current mail item from Recipient class
   */
  public void setCurrentRecipient(Recipient currentRecipient) {
    this.currentRecipient = currentRecipient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return width == mailItem.width && height == mailItem.height && depth == mailItem.depth
        && Objects.equals(currentRecipient, mailItem.currentRecipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, currentRecipient);
  }

  @Override
  public String toString() {
    return "MailItem{" +
        "width=" + width +
        ", height=" + height +
        ", depth=" + depth +
        ", currentRecipient=" + currentRecipient +
        '}';
  }
}
