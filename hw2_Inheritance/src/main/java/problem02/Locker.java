package problem02;

import java.util.Objects;
import hw2exceptions.*;

/**
 * CS5004 Spring2022 Jin Young Park hw20 Locker.java
 *
 * Locker stores the locker's capacity. It includes the locker's maximum width, maximum height,
 * maximum depth, and the item in the locker. The item in the locker is set to null when the locker
 * is created.
 */
public class Locker {

  protected int maxWidth;
  protected int maxHeight;
  protected int maxDepth;
  protected MailItem itemInLocker;

  /**
   * Constructor for Locker class
   *
   * @param maxWidth  - representing the width of the locker, as Integer
   * @param maxHeight - representing the height of the locker, as Integer
   * @param maxDepth  -  representing the depth of the locker, as Integer
   * @throws IllegalLengthException - if either maxWidth or maxHeight or maxDepth is lower than 1,
   *                                throws exception
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws IllegalLengthException {
    if (maxWidth >= 1) {
      this.maxWidth = maxWidth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }

    if (maxHeight >= 1) {
      this.maxHeight = maxHeight;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }

    if (maxDepth >= 1) {
      this.maxDepth = maxDepth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
    this.itemInLocker = null;
  }

  /**
   * Getter for maxWidth
   *
   * @return the width of the locker, as Integer
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Setter for width
   *
   * @param maxWidth - the width of the locker, encoded as Integer
   * @throws IllegalLengthException - when maxWidth input is lower than 0
   */
  public void setMaxWidth(int maxWidth) throws IllegalLengthException {
    if (maxWidth >= 1) {
      this.maxWidth = maxWidth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for maxHeight
   *
   * @return the height of the locker, as Integer
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Setter for height
   *
   * @param maxHeight - the height of the locker, encoded as Integer
   * @throws IllegalLengthException - when maxHeight input is lower than 0
   */
  public void setMaxHeight(int maxHeight) throws IllegalLengthException {
    if (maxHeight >= 1) {
      this.maxHeight = maxHeight;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for maxDepth
   *
   * @return the depth of the locker, as Integer
   */
  public int getMaxDepth() {
    return maxDepth;
  }

  /**
   * Setter for depth
   *
   * @param maxDepth - the depth of the locker, encoded as Integer
   * @throws IllegalLengthException - when maxDepth input is lower than 0
   */
  public void setMaxDepth(int maxDepth) throws IllegalLengthException {
    if (maxDepth >= 1) {
      this.maxDepth = maxDepth;
    } else {
      throw new IllegalLengthException("Invalid input!");
    }
  }

  /**
   * Getter for itemInLocker
   *
   * @return the mail item in the locker from MailItem class
   */
  public MailItem getItemInLocker() {
    return itemInLocker;
  }

  /**
   * Setter for itemInLocker
   *
   * @param itemInLocker - the mail item in the locker from MailItem class
   */
  public void setItemInLocker(MailItem itemInLocker) {
    this.itemInLocker = itemInLocker;
  }

  /**
   * Consumes a mail item and stores it in a locker with two exceptions: if the locker is occupied
   * (it already contains a mail item) or the mail item exceeds the dimensions of the locker (any
   * single dimension of the mail item is bigger than the locker), the mail item should not be added
   * to the locker.
   *
   * @param mailItem - the MailItem class that the user wants to put it in the locker
   * @throws exceedDimensionException - when the mail item exceeds dimensions of the locker
   * @throws lockerOccupiedException  - when the locker is already occupied
   */
  public void addMail(MailItem mailItem) throws exceedDimensionException, lockerOccupiedException {
    if (getItemInLocker() == null && mailItem.width <= maxWidth && mailItem.height <= maxHeight
        && mailItem.depth <= maxDepth) {
      setItemInLocker(mailItem);
    } else if (getItemInLocker() != null) {
      throw new lockerOccupiedException("The locker is occupied!");
    } else {
      throw new exceedDimensionException("Unable to put it in!");
    }
  }

  /**
   * Removes and returns the mail item from the locker under following conditions: there is a mail
   * item in the locker AND the recipient passed to pickupMail matches the recipient of the mail
   * item
   *
   * @param recipient - the recipient of the mail item that the user wants to pick up
   * @return mailItem if meets with all conditions. Otherwise, return null.
   * @throws IllegalPickUpException - when the recipient does not match with the recipient of the
   *                                mail item or the locker has nothing in it
   */
  public MailItem pickupMail(Recipient recipient) throws IllegalPickUpException {
    if (getItemInLocker() != null && getItemInLocker().currentRecipient.equals(recipient)) {
      MailItem mailToPickup = getItemInLocker();
      setItemInLocker(null);
      return mailToPickup;
    } else {
      throw new IllegalPickUpException("Not able to pick up!");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Locker locker = (Locker) o;
    return maxWidth == locker.maxWidth && maxHeight == locker.maxHeight
        && maxDepth == locker.maxDepth
        && Objects.equals(itemInLocker, locker.itemInLocker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxWidth, maxHeight, maxDepth, itemInLocker);
  }

  @Override
  public String toString() {
    return "Locker{" +
        "maxWidth=" + maxWidth +
        ", maxHeight=" + maxHeight +
        ", maxDepth=" + maxDepth +
        ", itemInLocker=" + itemInLocker +
        '}';
  }
}
