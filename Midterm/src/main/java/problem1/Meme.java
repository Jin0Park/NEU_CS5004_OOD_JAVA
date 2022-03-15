package problem1;

import java.util.ArrayList;

public class Meme extends NonFungibleTokens {

  public Meme(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed,
      Double latestAskingPrice, String tokenStandard)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, tokenStandard);
  }
}
