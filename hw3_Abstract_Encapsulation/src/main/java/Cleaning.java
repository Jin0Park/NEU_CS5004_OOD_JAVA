import java.util.Objects;
/**
 * CS5004 Spring2022 Jin Young Park hw3 Cleaning.java
 *
 * Cleaning is child class of Interior. It represents cleaning service.
 */
public class Cleaning extends Interior {

  /**
   * Constructor of Cleaning
   * @param propertyAddress - inherited from Interior
   * @param propertySize - inherited from Interior
   * @param receivedServicesMonthly - inherited from Interior
   * @param numOfServiceReceived - inherited from Interior
   * @param numOfPets - inherited from Interior
   */
  public Cleaning(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly,
      int numOfServiceReceived, int numOfPets) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived, numOfPets);
  }
}
