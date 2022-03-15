package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import problem1.Donation;

/**
 * CS5004 Spring2022 Jin Young Park hw5 LibraryCollection.java
 * <p>
 * LibraryCollection class stores information of a library collection. It is super class of Music
 * and Book.
 */
public abstract class LibraryCollection {

  protected String title;
  protected int yearOut;
  protected Creator creator;

  /**
   * Constructor of LibraryCollection class
   *
   * @param title   - title of a library collection, as String
   * @param yearOut - year published or released of a library collection, as integer
   * @param creator - creator of a library collection, as Creator
   */
  public LibraryCollection(String title, int yearOut, Creator creator) {
    this.title = title;
    this.yearOut = yearOut;
    this.creator = creator;
  }

  /**
   * getter of title
   *
   * @return title of a library collection
   */
  public String getTitle() {
    return title;
  }

  /**
   * setter of title
   *
   * @param title - changes the title of a library collection, encoded as String
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * getter of yearOut
   *
   * @return year published or released of a library collection
   */
  public int getYearOut() {
    return yearOut;
  }

  /**
   * setter of yearOut
   *
   * @param yearOut - changes the year published or released of a library collection, encoded as
   *                integer
   */
  public void setYearOut(int yearOut) {
    this.yearOut = yearOut;
  }

  /**
   * getter of Creator
   *
   * @return the creator of a library collection
   */
  public Creator getCreator() {
    return creator;
  }

  /**
   * setter of Creator
   *
   * @param creator - changes the creator of a library collection, encoded as Creator
   */
  public void setCreator(Creator creator) {
    this.creator = creator;
  }

  /**
   * equals method of LibraryCollection
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryCollection that = (LibraryCollection) o;
    return yearOut == that.yearOut && Objects.equals(title, that.title)
        && Objects.equals(creator, that.creator);
  }

  /**
   * hashCode method of LibraryCollection
   */
  @Override
  public int hashCode() {
    return Objects.hash(title, yearOut, creator);
  }
}