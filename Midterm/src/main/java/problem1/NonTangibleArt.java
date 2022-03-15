package problem1;

import java.util.ArrayList;

public abstract class NonTangibleArt extends ArtPiece {

  public NonTangibleArt(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice);
  }
}
