/**
 * CS5004 Spring2022 Jin Young Park hw3 Gardening.java
 *
 * Gardening is child class of Exterior. It represents gardening service.
 */
public class Gardening extends Exterior {

  private static final double feeForWasteRemoval = 20.00;

  /**
   * Constructor of Gardening
   *
   * @param propertyAddress         - inherited from Exterior
   * @param propertySize            - inherited from Exterior
   * @param receivedServicesMonthly - inherited from Exterior
   * @param numOfServiceReceived    - inherited from Exterior
   */
  public Gardening(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly,
      int numOfServiceReceived) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);
  }

  /**
   * Calculates the price of the service.
   *
   * @return the price of the gardening service.
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + feeForWasteRemoval;
  }
}
