package problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class TangibleArt extends ArtPiece {

  protected ArrayList<Double> widthHeight;
  private static final Double largeWidth = 12.0;
  private static final Double largeHeight = 16.0;
  private static final Double largeItemAdditionRate = 1.2;

  public TangibleArt(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice);
    this.widthHeight = widthHeight;
  }

  public ArrayList<Double> getWidthHeight() {
    return widthHeight;
  }

  public void setWidthHeight(ArrayList<Double> widthHeight) {
    this.widthHeight = widthHeight;
  }

  public Double applyLargeItemPriceChange(Double price) {
    // the input value will be calculated base price
    // apply price increase if it is larger than the width and height values provided
    if (this.widthHeight.get(0) > largeWidth && this.widthHeight.get(1) > largeHeight) {
      return price * largeItemAdditionRate;
    }
    return price;
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
    TangibleArt that = (TangibleArt) o;
    return Objects.equals(widthHeight, that.widthHeight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), widthHeight);
  }
}
