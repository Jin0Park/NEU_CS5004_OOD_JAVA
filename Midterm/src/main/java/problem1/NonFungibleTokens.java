package problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class NonFungibleTokens extends NonTangibleArt {

  protected String tokenStandard;
  private static final Integer daysToGetNFTToBeOld = 60;
  private static final String ethereumTokenHavingPriceDecrease = "ERC-721";
  private static final Double ethereumTokenPriceDecreaseRate = 0.6;

  public NonFungibleTokens(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, String tokenStandard)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice);
    this.tokenStandard = tokenStandard;
  }

  public String getTokenStandard() {
    return tokenStandard;
  }

  public void setTokenStandard(String tokenStandard) {
    this.tokenStandard = tokenStandard;
  }

  public Double applyOldEthereumPriceChange() {
    // with the calculated base price, apply price decrease if the item token standard matches ERC-721
    if (this.numOfDaysListed > daysToGetNFTToBeOld && this.getTokenStandard()
        .equals(ethereumTokenHavingPriceDecrease)) {
      return this.calculateBaseValue() * ethereumTokenPriceDecreaseRate;
    } else {
      return this.calculateBaseValue();
    }
  }

  @Override
  public Double calculateStartingBid() {
    return this.applyOldEthereumPriceChange();
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
    NonFungibleTokens that = (NonFungibleTokens) o;
    return Objects.equals(tokenStandard, that.tokenStandard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), tokenStandard);
  }

  @Override
  public String toString() {
    return "NonFungibleTokens{" +
        "name='" + name + '\'' +
        ", creator=" + creator +
        ", owner=" + owner +
        ", numOfDaysListed=" + numOfDaysListed +
        ", latestAskingPrice=" + latestAskingPrice +
        ", tokenStandard='" + tokenStandard + '\'' +
        '}';
  }
}
