/**
 * CS5004 Spring2022 Jin Young Park hw3 Exterior.java
 *
 * Exterior is parent abstract class of Gardening, WindowCleaning, and RoofGutterCleaning. It
 * inherits fields from NonSpecialService. It represents the services performed exterior of
 * property.
 */
public abstract class Exterior extends NonSpecialService {

  public Exterior(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);

  }
}
