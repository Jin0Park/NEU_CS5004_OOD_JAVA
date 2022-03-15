import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw3 RoofGutterCleaning.java
 * RoofGutterCleaning is child class of Exterior. It represents roof and gutter cleaning service.
 * It also stores information of the type of roof and square footage of the roof.
 */

public class RoofGutterCleaning extends Exterior {

  private static final int feeForLargeRoofPerHour = 50;
  private static final double largeRoofSquareFootage = 3000.0;
  private static final int feeForMansardRoof = 200;
  private TypeOfRoof TypeOfRoof;
  private double SquareFootageOfRoof;

  /**
   * Constructor of RoofGutterCleaning
   *
   * @param propertyAddress         - inherited from Exterior
   * @param propertySize            - inherited from Exterior
   * @param receivedServicesMonthly - inherited from Exterior
   * @param numOfServiceReceived    - inherited from Exterior
   * @param SquareFootageOfRoof     - the square footage of the roof, as double
   * @param TypeOfRoof              - the type of roof, as enum in TypeOfRoof
   */
  public RoofGutterCleaning(String propertyAddress, PropertySize propertySize,
      boolean receivedServicesMonthly, int numOfServiceReceived, double SquareFootageOfRoof,
      TypeOfRoof TypeOfRoof) {
    super(propertyAddress, propertySize, receivedServicesMonthly, numOfServiceReceived);
    this.SquareFootageOfRoof = SquareFootageOfRoof;
    this.TypeOfRoof = TypeOfRoof;
  }

  /**
   * Getter of TypeOfRoof
   *
   * @return the type of roof, as the enum value in TypeOfRoof
   */
  public TypeOfRoof getTypeOfRoof() {
    return TypeOfRoof;
  }

  /**
   * Setter of TypeofRoof
   *
   * @param TypeOfRoof - the type of roof, encoded as the enum value in TypeOfRoof
   */
  public void setTypeOfRoof(TypeOfRoof TypeOfRoof) {
    this.TypeOfRoof = TypeOfRoof;
  }

  /**
   * Getter of SquareFootageOfRoof
   *
   * @return the square footage of roof, as double
   */
  public double getSquareFootageOfRoof() {
    return SquareFootageOfRoof;
  }

  /**
   * Setter of SquareFootageOfRoof
   *
   * @param SquareFootageOfRoof - the square footage of roof, encoded as double
   */
  public void setSquareFootageOfRoof(double SquareFootageOfRoof) {
    this.SquareFootageOfRoof = SquareFootageOfRoof;
  }

  /**
   * Calculates the price of service under certain conditions
   * if roof is larger than 3000 square footage, then there will be fee added per hour.
   * if type of roof is mansard, then there will be fee added.
   * @return the price of Roof and Gutter cleaning service
   */
  @Override
  public double calculatePrice() {
    double totalPrice = super.calculatePrice();
    if (this.SquareFootageOfRoof > largeRoofSquareFootage) {
      totalPrice += feeForLargeRoofPerHour * calculateHour();
    }
    if (this.TypeOfRoof == TypeOfRoof.MANSARD) {
      totalPrice += feeForMansardRoof;
    }
    return totalPrice;
  }

  /**
   * equal method in RoofGutterCleaning
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
    RoofGutterCleaning that = (RoofGutterCleaning) o;
    return Double.compare(that.SquareFootageOfRoof, SquareFootageOfRoof) == 0
        && TypeOfRoof == that.TypeOfRoof;
  }

  /**
   * hashcode method in RoofGutterCleaning
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), TypeOfRoof, SquareFootageOfRoof);
  }

  /**
   * toString method in RoofGutterCleaning
   */
  @Override
  public String toString() {
    return "RoofGutterCleaning{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", isMonthlyService=" + isMonthlyService +
        ", numOfServiceReceived=" + numOfServiceReceived +
        ", TypeOfRoof=" + TypeOfRoof +
        ", SquareFootageOfRoof=" + SquareFootageOfRoof +
        '}';
  }
}
