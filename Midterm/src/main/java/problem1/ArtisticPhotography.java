package problem1;

import java.util.ArrayList;

public class ArtisticPhotography extends Photographs{
    public ArtisticPhotography(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight, String makeOfCamera, String modelOfCamera) throws InvalidPriceException, InvalidNumOfDaysListedException {
        super(name, creator, owner, numOfDaysListed, latestAskingPrice, widthHeight, makeOfCamera, modelOfCamera);
    }
}
