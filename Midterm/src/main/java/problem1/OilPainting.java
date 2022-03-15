package problem1;

import java.util.ArrayList;

public class OilPainting extends Paintings {

  public OilPainting(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, widthHeight);
  }
}
