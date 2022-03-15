package problem2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Book.java
 * <p>
 * Book class stores information of a book. It inherits LibraryCollection class.
 */
public class Book extends LibraryCollection {

  /**
   * Constructor of Book class
   *
   * @param title   - title of a library collection, as String
   * @param yearOut - year published or released of a library collection, as integer
   * @param author  - creator of a library collection, as Author
   */
  public Book(String title, int yearOut, Author author) {
    super(title, yearOut, author);
  }

  /**
   * toString method of Book
   */
  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", yearOut=" + yearOut +
        ", creator=" + creator +
        '}';
  }
}