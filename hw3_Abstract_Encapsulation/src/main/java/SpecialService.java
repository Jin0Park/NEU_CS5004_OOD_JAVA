import hw3exceptions.ExceedMaxLicensedEmployeeException;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw3 SpecialService.java
 *
 * SpecialService is an abstract class, and is a child class of PropertyService. It represents
 * property services that require special service. It contains assignLicensedEmployee, getters and
 * setters for fields of whether it is complex work and the number of licensed employee required.
 */

public abstract class SpecialService extends PropertyService {

  protected int numOfSpecialistRequired;
  protected boolean isComplex;
  private static final double specialServicePricePerHour = 200.00;
  private static final int minSpecialistSmallMediumProperty = 2;
  private static final int minSpecialistLargeProperty = 3;

  /**
   * Constructor of SpecialService
   *
   * @param propertyAddress         - inherited from PropertyService
   * @param propertySize            - inherited from PropertyService
   * @param receivedServicesMonthly - inherited from PropertyService
   * @param numOfServiceReceived    - inherited from PropertyService
   * @param isComplex               - representing whether the service is complex work, as boolean
   * @param numOfSpecialistRequired - representing the number of licensed employee required, as int
   */
  public SpecialService(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, boolean isComplex,
      int numOfSpecialistRequired) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);
    this.isComplex = isComplex;
    assignLicensedEmployee(numOfSpecialistRequired);
  }

  /**
   * Assigns the number of licensed employee under conditions.
   *
   * @param number - the parameter of this method and is the value of numOfSpecialistRequired
   */
  private void assignLicensedEmployee(int number) {
    if (isComplex) {
      if (super.getPropertySize() == PropertySize.MEDIUM
          || super.getPropertySize() == PropertySize.SMALL) {
        if (number < minSpecialistSmallMediumProperty) {
          this.numOfSpecialistRequired = minSpecialistSmallMediumProperty;
        } else {
          this.numOfSpecialistRequired = number;
        }
      } else {
        if (number < minSpecialistLargeProperty) {
          this.numOfSpecialistRequired = minSpecialistLargeProperty;
        } else {
          this.numOfSpecialistRequired = number;
        }
      }
    } else if (number < 1) {
      this.numOfSpecialistRequired = 1;
    } else {
      this.numOfSpecialistRequired = number;
    }
  }

  /**
   * Getter for numOfSpecialistRequired
   *
   * @return the number of licensed employee required, as int
   */
  public int getNumOfSpecialistRequired() {
    return this.numOfSpecialistRequired;
  }

  /**
   * Setter for numOfSpecialistRequired
   *
   * @param numOfSpecialistRequired - number of licensed employee required, encoded as int
   * @throws ExceedMaxLicensedEmployeeException - throws exception when the input value exceeds
   *                                            maximum licensed employee limit for certain classes
   */
  public void setNumOfSpecialistRequired(int numOfSpecialistRequired)
      throws ExceedMaxLicensedEmployeeException {
    this.numOfSpecialistRequired = numOfSpecialistRequired;
  }

  /**
   * Getter for isComplex
   *
   * @return whether the service is complex, as boolean
   */
  public boolean isComplex() {
    return isComplex;
  }

  /**
   * Setter for isComplex
   *
   * @param complex - whether the service is complex, encoded as boolean
   */
  public void setComplex(boolean complex) {
    isComplex = complex;
  }

  /**
   * Calculates the price of the service
   *
   * @return the price of the service in double
   */
  @Override
  public double calculatePrice() {
    return specialServicePricePerHour * this.getNumOfSpecialistRequired();
  }

  /**
   * equal method for SpecialService
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
    SpecialService that = (SpecialService) o;
    return numOfSpecialistRequired == that.numOfSpecialistRequired && isComplex == that.isComplex;
  }

  /**
   * hashcode method for SpecialService
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfSpecialistRequired, isComplex);
  }

  /**
   * toString method of Special Service
   */
  @Override
  public String toString() {
    return "SpecialService{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthlyService=" + isMonthlyService +
        ", numOfServiceReceived=" + numOfServiceReceived +
        ", numOfSpecialistRequired=" + numOfSpecialistRequired +
        ", isComplex=" + isComplex +
        '}';
  }
}
