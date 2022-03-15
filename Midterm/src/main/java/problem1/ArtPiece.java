package problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ArtPiece implements Auction {
    protected String name;
    protected ArrayList<Name> creator;
    protected ArrayList<Name> owner;
    protected Integer numOfDaysListed;
    protected Double latestAskingPrice;
    private static final Double baseValueAdditionRate = 1.25;


    public ArtPiece(String name, ArrayList<Name> creator, ArrayList<Name> owner, Integer numOfDaysListed, Double latestAskingPrice) throws InvalidNumOfDaysListedException, InvalidPriceException {
        this.name = name;
        this.creator = creator;
        this.owner = owner;
        if (numOfDaysListed < 0)
            throw new InvalidNumOfDaysListedException("Invalid Days!");
        else this.numOfDaysListed = numOfDaysListed;
        if (latestAskingPrice < 0)
            throw new InvalidPriceException("Invalid Price!");
        else this.latestAskingPrice = latestAskingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Name> getCreator() {
        return creator;
    }

    public void setCreator(ArrayList<Name> creator) {
        this.creator = creator;
    }

    public ArrayList<Name> getOwner() {
        return owner;
    }

    public void setOwner(ArrayList<Name> owner) {
        this.owner = owner;
    }

    public Integer getNumOfDaysListed() {
        return numOfDaysListed;
    }

    /**
     * setter for numOfDaysListed
     * @param numOfDaysListed - the number of days listed on auction
     * @throws InvalidNumOfDaysListedException - throws an exception when the given day value is below zero
     */
    public void setNumOfDaysListed(Integer numOfDaysListed) throws InvalidNumOfDaysListedException {
        if (numOfDaysListed < 0) {
            throw new InvalidNumOfDaysListedException("Invalid Days!");
        }
        this.numOfDaysListed = numOfDaysListed;
    }

    public Double getLatestAskingPrice() {
        return latestAskingPrice;
    }

    /**
     * setter for latestAskingPrice
     * @param latestAskingPrice - the latest asking price for the item
     * @throws InvalidPriceException - throws an exception when the given price value is below zero
     */
    public void setLatestAskingPrice(Double latestAskingPrice) throws InvalidPriceException {
        if (latestAskingPrice < 0) {
            throw new InvalidPriceException("Invalid Price!");
        }
        this.latestAskingPrice = latestAskingPrice;
    }

    public Double calculateBaseValue() {
        return this.latestAskingPrice * baseValueAdditionRate;
    }

    public Double calculateStartingBid() {
        return this.calculateBaseValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtPiece artPiece = (ArtPiece) o;
        return Objects.equals(name, artPiece.name) && Objects.equals(creator, artPiece.creator) && Objects.equals(owner, artPiece.owner) && Objects.equals(numOfDaysListed, artPiece.numOfDaysListed) && Objects.equals(latestAskingPrice, artPiece.latestAskingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creator, owner, numOfDaysListed, latestAskingPrice);
    }

    @Override
    public String toString() {
        return "ArtPiece{" +
                "name='" + name + '\'' +
                ", creator=" + creator +
                ", owner=" + owner +
                ", numOfDaysListed=" + numOfDaysListed +
                ", latestAskingPrice=" + latestAskingPrice +
                '}';
    }
}
