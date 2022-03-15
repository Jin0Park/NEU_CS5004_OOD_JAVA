package problem01;

import java.util.Objects;
import java.time.LocalDateTime;

public abstract class PerishableFoodItem extends FoodItem {
  protected LocalDateTime orderDate;
  protected LocalDateTime expirationDate;

  public PerishableFoodItem(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate, LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public LocalDateTime getExpirationDate() {
    return expirationDate;
  }

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
    PerishableFoodItem that = (PerishableFoodItem) o;
    return orderDate == that.orderDate && expirationDate == that.expirationDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderDate, expirationDate);
  }

  @Override
  public String toString() {
    return "PerishableFoodItem{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
