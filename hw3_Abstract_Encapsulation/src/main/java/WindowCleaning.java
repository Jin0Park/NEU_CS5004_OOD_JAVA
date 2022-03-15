import hw3exceptions.ExceedMaxFloorException;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw3 WindowCleaning.java
 *
 * WindowCleaning is child class of Exterior. It represents window cleaning service.
 * It also stores information of the number of floors of the property.
 */

public class WindowCleaning extends Exterior {

  private int numOfFloors;
  private static final int maxFloor = 3;
  private static final double feeForMultipleFloorPercentage = 0.05;

  /**
   * Constructor of WindowCleaning
   *
   * @param propertyAddress         - inherited from Exterior
   * @param propertySize            - inherited from Exterior
   * @param receivedServicesMonthly - inherited from Exterior
   * @param numOfServiceReceived    - inherited from Exterior
   * @param numOfFloors             - the number of floors, as int
   * @throws ExceedMaxFloorException - throws exception when the number of floors exceeds the
   *                                 maximum floor that the service can be performed, which is 3
   */
  public WindowCleaning(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, int numOfFloors)
      throws ExceedMaxFloorException {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);
    if (numOfFloors > maxFloor) {
      throw new ExceedMaxFloorException("Not available!");
    } else {
      this.numOfFloors = numOfFloors;
    }
  }

  /**
   * Getter of numOfFloors
   *
   * @return the number of floors, as int
   */
  public int getNumOfFloors() {
    return numOfFloors;
  }

  /**
   * Setter of numOfFloors
   *
   * @param numOfFloors - the number of floors, encoded as int
   * @throws ExceedMaxFloorException - throws exception when the number of floors exceeds the
   *                                 maximum floor that the service can be performed, which is 3
   */
  public void setNumOfFloors(int numOfFloors) throws ExceedMaxFloorException {
    if (numOfFloors > maxFloor) {
      throw new ExceedMaxFloorException("Not available!");
    } else {
      this.numOfFloors = numOfFloors;
    }
  }

  /**
   * Calculate the price of the service
   * if there is more than one floor, then there will be additional charge.
   * @return the price of window cleaning service as double
   */
  @Override
  public double calculatePrice() {
    if (this.getNumOfFloors() > 1) {
      return super.calculatePrice() * (1 + feeForMultipleFloorPercentage);
    }
    return super.calculatePrice();
  }

  /**
   * equal method of WindowCleaning
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
    WindowCleaning that = (WindowCleaning) o;
    return numOfFloors == that.numOfFloors;
  }

  /**
   * hashcode method of WindowCleaning
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfFloors);
  }

  /**
   * toString method of WindowCleaning
   */
  @Override
  public String toString() {
    return "WindowCleaning{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthlyService=" + isMonthlyService +
        ", numOfServiceReceived=" + numOfServiceReceived +
        ", numOfFloors=" + numOfFloors +
        '}';
  }
}
