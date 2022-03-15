import hw3exceptions.ExceedMaxLicensedEmployeeException;

/**
 * CS5004 Spring2022 Jin Young Park hw3 Electrical.java
 *
 * Electrical is child class of SpecialService. It represents electrical service.
 */
public class Electrical extends SpecialService {

  private static final double electricalWorkPermittingFee = 50.00;
  private static final int maxSpecialistForElectrical = 4;

  /**
   * Constructor of Electrical
   *
   * @param propertyAddress-         inherited from SpecialService
   * @param propertySize-            inherited from SpecialService
   * @param receivedServicesMonthly- inherited from SpecialService
   * @param numOfServiceReceived-    inherited from SpecialService
   * @param isComplex-               inherited from SpecialService
   * @param numOfSpecialistRequired- inherited from SpecialService
   * @throws ExceedMaxLicensedEmployeeException - throws exception when the given input value for
   *                                            the number of licensed employee required exceeds the
   *                                            maximum number of licensed employee can be assigned
   *                                            for this service.
   */
  public Electrical(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, boolean isComplex,
      int numOfSpecialistRequired) throws ExceedMaxLicensedEmployeeException {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived, isComplex,
        numOfSpecialistRequired);
    if (numOfSpecialistRequired > maxSpecialistForElectrical) {
      throw new ExceedMaxLicensedEmployeeException("Not Available!");
    }
  }

  /**
   * Setter for numOfSpecialistRequired (override)
   *
   * @param numOfSpecialistRequired - number of licensed employee required, encoded as int
   * @throws ExceedMaxLicensedEmployeeException - throws exception when the given input value for
   *                                            the number of licensed employee required exceeds the
   *                                            maximum number of licensed employee can be assigned
   *                                            for this service.
   */
  @Override
  public void setNumOfSpecialistRequired(int numOfSpecialistRequired)
      throws ExceedMaxLicensedEmployeeException {
    if (numOfSpecialistRequired > maxSpecialistForElectrical) {
      throw new ExceedMaxLicensedEmployeeException("Not Available!");
    } else {
      super.setNumOfSpecialistRequired(numOfSpecialistRequired);
    }
  }

  /**
   * Calculate the price of the service
   * There will be additional electrical work permitting fee.
   * @return the price of the Electrical service in double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + electricalWorkPermittingFee;
  }
}
