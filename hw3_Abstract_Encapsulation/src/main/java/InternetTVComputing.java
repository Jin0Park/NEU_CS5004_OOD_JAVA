import hw3exceptions.ExceedMaxLicensedEmployeeException;

/**
 * CS5004 Spring2022 Jin Young Park hw3 InternetTVComputing.java
 *
 * InternetTVComputing is child class of SpecialService. It represents internet, TV, or computing
 * service.
 */

public class InternetTVComputing extends SpecialService {

  protected static final double electronicWasteFee = 15.00;
  private static final int maxSpecialistForInternetTVComputings = 2;

  /**
   * Constructor of InternetTVComputing
   *
   * @param propertyAddress         - inherited from SpecialService
   * @param propertySize            - inherited from SpecialService
   * @param receivedServicesMonthly - inherited from SpecialService
   * @param numOfServiceReceived    - inherited from SpecialService
   * @param isComplex               - inherited from SpecialService
   * @param numOfSpecialistRequired - inherited from SpecialService
   * @throws ExceedMaxLicensedEmployeeException - throws exception when the given input value for
   *                                            the number of licensed employee required exceeds the
   *                                            maximum number of licensed employee can be assigned
   *                                            for this service.
   */
  public InternetTVComputing(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, boolean isComplex,
      int numOfSpecialistRequired) throws ExceedMaxLicensedEmployeeException {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived, isComplex,
        numOfSpecialistRequired);
    if (numOfSpecialistRequired > maxSpecialistForInternetTVComputings) {
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
    if (numOfSpecialistRequired > maxSpecialistForInternetTVComputings) {
      throw new ExceedMaxLicensedEmployeeException("Not Available!");
    } else {
      super.setNumOfSpecialistRequired(numOfSpecialistRequired);
    }
  }

  /**
   * Calculate the price of the service
   * There will be additional charge for electronic waste.
   * @return the price of the Internet, TV, Computing service in double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + electronicWasteFee;
  }

}
