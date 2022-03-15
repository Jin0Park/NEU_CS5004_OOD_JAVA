/**
 * CS5004 Spring2022 Jin Young Park hw3 NonSpecialService.java
 *
 * NonSpecialService is an abstract class, and is a child class of PropertyService, and is a parent
 * class of Interior and Exterior. It represents property services that do not require special
 * service. It contains calculateHour, calculatePrice, applyDiscount methods for Interior and
 * Exterior services.
 */
public abstract class NonSpecialService extends PropertyService {

  private static final int nonSpecialServiceSmallHour = 1;
  private static final int nonSpecialServiceMediumHour = 2;
  private static final int nonSpecialServiceLargeHour = 4;
  protected static final double tenthServiceDiscountPercentage = 0.5;
  protected static final double monthlyDiscountPercentage = 0.1;
  protected static final int numOfServicesToGetDiscount = 10;
  protected static final double nonSpecialServicePricePerHour = 80.00;

  /**
   * Constructor of NonSpecialService
   *
   * @param propertyAddress      - inherited from PropertyService
   * @param propertySize         - inherited from PropertyService
   * @param isMonthlyService     - inherited from PropertyService
   * @param numOfServiceReceived - inherited from PropertyService
   */
  public NonSpecialService(String propertyAddress, PropertySize propertySize,
      boolean isMonthlyService,
      int numOfServiceReceived) {
    super(propertyAddress, propertySize, isMonthlyService, numOfServiceReceived);
  }

  /**
   * Calculate the time required to perform a service.
   *
   * @return the hour required for the service, in int
   */
  public int calculateHour() {
    if (super.getPropertySize() == PropertySize.LARGE) {
      return nonSpecialServiceLargeHour;
    } else if (super.getPropertySize() == PropertySize.MEDIUM) {
      return nonSpecialServiceMediumHour;
    } else {
      return nonSpecialServiceSmallHour;
    }
  }

  /**
   * Calculate the price of the service.
   *
   * @return the price of the service in double.
   */
  @Override
  public double calculatePrice() {
    return nonSpecialServicePricePerHour * this.calculateHour();
  }

  /**
   * Apply discount if applicable.
   *
   * @return the price after discount if applicable in double
   */
  public double applyDiscount() {
    if (getNumOfServiceReceived() % 10 == numOfServicesToGetDiscount - 1) {
      return calculatePrice() * (1 - tenthServiceDiscountPercentage);
    } else if (isMonthlyService) {
      return calculatePrice() * (1 - monthlyDiscountPercentage);
    }
    return calculatePrice();
  }

}
