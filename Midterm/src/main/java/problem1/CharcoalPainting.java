package problem1;

import java.util.ArrayList;

public class CharcoalPainting extends Paintings{

    public CharcoalPainting(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight) throws InvalidPriceException, InvalidNumOfDaysListedException {
        super(name, creator, owner, numOfDaysListed, latestAskingPrice, widthHeight);
    }
}
