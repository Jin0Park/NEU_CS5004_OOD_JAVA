import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw3 Interior.java
 *
 * Interior is parent abstract class of Cleaning and Painting. It inherits fields from
 * NonSpecialService. It also contains the information of the number of pets in the property. It
 * represents the services performed interior of property.
 */
public abstract class Interior extends NonSpecialService {

  private int numOfPets;
  protected static final int numToBeManyPet = 3;
  protected static final double feeForPetPercentage = 0.05;
  protected static final double feeForManyPetPercentage = 0.07;

  /**
   * Constructor of Interior
   *
   * @param propertyAddress         - inherited from NonSpecialService
   * @param propertySize            - inherited from NonSpecialService
   * @param receivedServicesMonthly - inherited from NonSpecialService
   * @param numOfServiceReceived    - inherited from NonSpecialService
   * @param numOfPets               - the number of pets in the property, as int
   */
  public Interior(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, int numOfPets) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);
    this.numOfPets = numOfPets;
  }

  /**
   * Getter for numOfPets
   *
   * @return the number of pets, as int
   */
  public int getNumOfPets() {
    return numOfPets;
  }

  /**
   * Setter for numOfPets
   *
   * @param numOfPets - the number of pets, encoded as int
   */
  public void setNumOfPets(int numOfPets) {
    this.numOfPets = numOfPets;
  }

  /**
   * Calculate the price of the service
   * There will be additional charge for pets in the property.
   * @return the price of the service, as double
   */
  @Override
  public double calculatePrice() {
    if (this.getNumOfPets() < numToBeManyPet && this.getNumOfPets() > 0) {
      return super.calculatePrice() * (1 + feeForPetPercentage);
    } else if (this.getNumOfPets() >= numToBeManyPet) {
      return super.calculatePrice() * (1 + feeForManyPetPercentage);
    }
    return super.calculatePrice();
  }

  /**
   * equal method of Interior
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
    Interior interior = (Interior) o;
    return numOfPets == interior.numOfPets;
  }

  /**
   * hashcode method of Interior
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfPets);
  }

  /**
   * toString method of Interior
   * @return
   */
  @Override
  public String toString() {
    return "Interior{" +
        "numOfPets=" + numOfPets +
        ", propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthlyService=" + isMonthlyService +
        ", numOfServiceReceived=" + numOfServiceReceived +
        '}';
  }
}
