package problem2;

/**
 * CS5004 Spring2022 Jin Young Park hw5 GroupArtist.java
 * <p>
 * GroupArtist class stores information of GroupArtist such as band of a library collection. It is
 * super class of Band. Inherits Creator class.
 */
public abstract class GroupArtist extends Creator {

  /**
   * Constructor of GroupArtist class
   *
   * @param name - the name of the Creator, as String. It is a name of a name of a band.
   */
  public GroupArtist(String name) {
    super(name);
  }
}