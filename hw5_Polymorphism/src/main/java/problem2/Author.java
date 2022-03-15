package problem2;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Author.java
 * <p>
 * Author class stores information of an author of a book. Inherits SingleArtist class.
 */
public class Author extends SingleArtist {

  /**
   * Constructor of Author class
   *
   * @param name - the name of the Creator, as String.
   */
  public Author(String name) {
    super(name);
  }

  /**
   * toString method of Author class
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        '}';
  }
}