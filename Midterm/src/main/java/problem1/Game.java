package problem1;

import java.util.ArrayList;

public class Game extends NonFungibleTokens {

  public Game(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed,
      Double latestAskingPrice, String tokenStandard)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, tokenStandard);
  }
}
