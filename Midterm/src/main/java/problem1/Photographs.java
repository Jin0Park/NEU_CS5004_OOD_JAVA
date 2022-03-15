package problem1;

import java.util.ArrayList;

public abstract class Photographs extends TangibleArt {

  protected String makeOfCamera;
  protected String modelOfCamera;
  protected static final String valuableMakeOfCamera = "Canon";
  protected static final String valuableModelOfCamera = "EOS R5";
  private static final Double valuablePhotoPriceChangeRate = 1.35;


  public Photographs(String name, ArrayList<Name> creator, ArrayList<Name> owner,
      Integer numOfDaysListed, Double latestAskingPrice, ArrayList<Double> widthHeight,
      String makeOfCamera, String modelOfCamera)
      throws InvalidPriceException, InvalidNumOfDaysListedException {
    super(name, creator, owner, numOfDaysListed, latestAskingPrice, widthHeight);
    this.makeOfCamera = makeOfCamera;
    this.modelOfCamera = modelOfCamera;
  }

  public String getMakeOfCamera() {
    return makeOfCamera;
  }

  public void setMakeOfCamera(String makeOfCamera) {
    this.makeOfCamera = makeOfCamera;
  }

  public String getModelOfCamera() {
    return modelOfCamera;
  }

  public void setModelOfCamera(String modelOfCamera) {
    this.modelOfCamera = modelOfCamera;
  }

  @Override
  public Double calculateStartingBid() {
    // get price after applying large item price change with the base value
    Double price = this.applyLargeItemPriceChange(this.calculateBaseValue());
    // apply price increase if it was taken with specific camera
    if (this.getMakeOfCamera().equals(valuableMakeOfCamera) && this.getModelOfCamera()
        .equals(valuableModelOfCamera)) {
      return price * valuablePhotoPriceChangeRate;
    }
    return price;
  }

  @Override
  public String toString() {
    return "Photographs{" +
        "name='" + name + '\'' +
        ", creator=" + creator +
        ", owner=" + owner +
        ", numOfDaysListed=" + numOfDaysListed +
        ", latestAskingPrice=" + latestAskingPrice +
        ", makeOfCamera='" + makeOfCamera + '\'' +
        ", modelOfCamera='" + modelOfCamera + '\'' +
        ", widthHeight=" + widthHeight +
        '}';
  }
}
