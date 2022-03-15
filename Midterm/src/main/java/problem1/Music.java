package problem1;

import java.util.ArrayList;

public class Music extends NonFungibleTokens {

  public Music(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed,
      Double latestAskingPrice, String tokenStandard)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, tokenStandard);
  }
}
