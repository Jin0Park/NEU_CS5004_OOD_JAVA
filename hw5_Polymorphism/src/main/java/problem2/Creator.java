package problem2;

import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Creator.java
 * <p>
 * Creator class stores information of creator of a library collection. It is super class of
 * SingleArtist and GroupArtist.
 */
public abstract class Creator {

  protected String name;

  /**
   * Constructor of Creator class
   *
   * @param name - the name of the Creator, as String. It can be a name of a single artist or a name
   *             of a band.
   */
  public Creator(String name) {
    this.name = name;
  }

  /**
   * getter of name
   *
   * @return the name of the creator of a library collection.
   */
  public String getName() {
    return name;
  }

  /**
   * setter of name
   *
   * @param name - the name of the creator of a library collection, encoded as String
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * checks if a given Creator matches with the creator of a library collection. checks by the name
   * of a creator.
   *
   * @param c - Creator of a library collection
   * @return true if matches, false otherwise.
   */
  public boolean matchedCreator(Creator c) {
    return c.name.equals(this.name);
  }

  /**
   * equals method of Creator class
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Creator creator = (Creator) o;
    return Objects.equals(name, creator.name);
  }

  /**
   * hashCode method of Creator class
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}