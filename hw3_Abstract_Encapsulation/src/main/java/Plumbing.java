/**
 * CS5004 Spring2022 Jin Young Park hw3 Plumbing.java
 *
 * Plumbing is child class of SpecialService. It represents plumbing service.
 */
public class Plumbing extends SpecialService {

  protected static final double plumbingWorkPermittingFee = 20.00;

  /**
   * Constructor of Plumbing
   *
   * @param propertyAddress-         inherited from SpecialService
   * @param propertySize-            inherited from SpecialService
   * @param receivedServicesMonthly- inherited from SpecialService
   * @param numOfServiceReceived-    inherited from SpecialService
   * @param isComplex-               inherited from SpecialService
   * @param numOfSpecialistRequired- inherited from SpecialService
   */
  public Plumbing(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, boolean isComplex,
      int numOfSpecialistRequired) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived, isComplex,
        numOfSpecialistRequired);
  }

  /**
   * Calculate the price of the service
   * There will be additional plumbing work permitting fee.
   * @return the price of the Plumbing service in double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + plumbingWorkPermittingFee;
  }
}