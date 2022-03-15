package problem1;

import java.util.ArrayList;

public class DigitalArt extends NonFungibleTokens {

  private static final Integer daysToGetMemeToBeOld = 15;
  private static final Double oldMemePriceChangeRate = 0.7;

  public DigitalArt(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, String tokenStandard)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, tokenStandard);
  }

  @Override
  public Double calculateStartingBid() {
    // get the price after calculating base price, applying old/ethereum price change
    Double price = this.applyOldEthereumPriceChange();
    // apply price decrease if the meme (digitalArt) is older than 15 days.
    if (this.numOfDaysListed > daysToGetMemeToBeOld) {
      return price * oldMemePriceChangeRate;
    } else {
      return price;
    }
  }
}
