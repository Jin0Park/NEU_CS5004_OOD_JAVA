import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw3 PropertyService.java
 *
 * PropertyService is parent abstract class of NonSpecialService and SpecialService. It stores
 * information about the property for the property service system. The information contains address,
 * size, number of service received, and whether the service is monthly service.
 */

public abstract class PropertyService {

  protected String propertyAddress;
  protected PropertySize propertySize;
  protected boolean isMonthlyService;
  protected int numOfServiceReceived;

  /**
   * Constructor of PropertyService
   *
   * @param propertyAddress      - representing the address of the property, as String
   * @param propertySize         - representing the size of the property, as PropertySize Enum
   * @param isMonthlyService     - representing whether it is monthly service, as Boolean
   * @param numOfServiceReceived - representing the number of service received, as integer
   */
  public PropertyService(String propertyAddress, PropertySize propertySize,
      boolean isMonthlyService, int numOfServiceReceived) {
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.isMonthlyService = isMonthlyService;
    this.numOfServiceReceived = numOfServiceReceived;
  }

  /**
   * Getter for propertyAddress
   *
   * @return address of the property, as String
   */
  public String getPropertyAddress() {
    return propertyAddress;
  }

  /**
   * Setter for propertyAddress
   *
   * @param propertyAddress - the address, encoded as String
   */
  public void setPropertyAddress(String propertyAddress) {
    this.propertyAddress = propertyAddress;
  }

  /**
   * Getter for propertySize
   *
   * @return size of the property, as enum in PropertySize
   */
  public PropertySize getPropertySize() {
    return propertySize;
  }

  /**
   * Setter for propertySize
   *
   * @param propertySize - the property size, encoded as enum in PropertySize
   */
  public void setPropertySize(PropertySize propertySize) {
    this.propertySize = propertySize;
  }

  /**
   * Getter for isMonthlyService
   *
   * @return whether it is monthly service, as boolean
   */
  public boolean isMonthlyService() {
    return isMonthlyService;
  }

  /**
   * Setter for isMonthlyService
   *
   * @param monthlyService - whether it is monthly service, encoded as boolean
   */
  public void setMonthlyService(boolean monthlyService) {
    isMonthlyService = monthlyService;
  }

  /**
   * Getter for numOfServiceReceived
   *
   * @return the number of service received, as int
   */
  public int getNumOfServiceReceived() {
    return numOfServiceReceived;
  }

  /**
   * Setter for numOfServiceReceived
   *
   * @param numOfServiceReceived - number of service received, encoded as int
   */
  public void setNumOfServiceReceived(int numOfServiceReceived) {
    this.numOfServiceReceived = numOfServiceReceived;
  }

  /**
   * abstract method to calculate price of the service. It will be overrided in child classes.
   *
   * @return the price of the service, as double
   */
  public abstract double calculatePrice();

  /**
   * equal method of propertyService
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertyService that = (PropertyService) o;
    return isMonthlyService == that.isMonthlyService
        && numOfServiceReceived == that.numOfServiceReceived && propertyAddress.equals(
        that.propertyAddress) && propertySize == that.propertySize;
  }

  /**
   * hashcode method of propertyService
   */
  @Override
  public int hashCode() {
    return Objects.hash(propertyAddress, propertySize, isMonthlyService, numOfServiceReceived);
  }

  @Override
  public String toString() {
    return "PropertyService{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthlyService=" + isMonthlyService +
        ", numOfServiceReceived=" + numOfServiceReceived +
        '}';
  }
}
