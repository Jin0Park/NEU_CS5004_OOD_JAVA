package problem1;

import java.util.ArrayList;

public abstract class Paintings extends TangibleArt {

  private static final Integer daysToBeOldPainting = 100;
  private static final Double priceToBeHigh = 2000.0;
  private static final Double oldPaintingPriceChangeRate = 0.8;

  public Paintings(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, widthHeight);
  }

  @Override
  public Double calculateStartingBid() {
    // get price after applying large item price change with the base value
    Double price = this.applyLargeItemPriceChange(this.calculateBaseValue());
    // apply old painting price change
    if (this.numOfDaysListed > daysToBeOldPainting && price > priceToBeHigh) {
      return price * oldPaintingPriceChangeRate;
    }
    return price;
  }

  @Override
  public String toString() {
    return "Paintings{" +
        "name='" + name + '\'' +
        ", creator=" + creator +
        ", owner=" + owner +
        ", numOfDaysListed=" + numOfDaysListed +
        ", latestAskingPrice=" + latestAskingPrice +
        ", widthHeight=" + widthHeight +
        '}';
  }
}
