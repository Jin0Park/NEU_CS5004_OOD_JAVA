import java.util.Objects;
/**
 * CS5004 Spring2022 Jin Young Park hw3 Painting.java
 *
 * Painting is child class of Interior. It represents painting service.
 * It calculates the hour the service under conditions.
 */
public class Painting extends Interior {
  private static final int paintingSmallMediumHour = 16;
  private static final int paintingLargeHour = 24;

  /**
   * Constructor of Painting
   * @param propertyAddress - inherited from Interior
   * @param propertySize - inherited from Interior
   * @param receivedServicesMonthly - inherited from Interior
   * @param numOfServiceReceived - inherited from Interior
   * @param numOfPets - inherited from Interior
   */
  public Painting(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly,
      int numOfServiceReceived, int numOfPets) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived, numOfPets);
  }

  /**
   * Calculate the time required for the service
   * @return the hour required for the service, as int
   */
  @Override
  public int calculateHour() {
    if (this.getPropertySize() == PropertySize.LARGE) {
      return paintingLargeHour;
    } else {
      return paintingSmallMediumHour;
    }
  }
}
