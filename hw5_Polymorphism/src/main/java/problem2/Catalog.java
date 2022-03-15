package problem2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Catalog.java
 * <p>
 * Catalog class stores information of a library collection list. It collects and removes items from
 * list and also searches by keyword, author, recording artist.
 */
public class Catalog {

  protected ArrayList<LibraryCollection> collectionList;

  /**
   * Constructor of Catalog
   *
   * @param collectionList - list of library collections, as ArrayList
   */
  public Catalog(ArrayList<LibraryCollection> collectionList) {
    this.collectionList = collectionList;
  }

  /**
   * getter of collectionList
   *
   * @return collection list of library collection items.
   */
  public ArrayList<LibraryCollection> getCollectionList() {
    return collectionList;
  }

  /**
   * adds item into collectionList
   *
   * @param item - LibraryCollection item, it can be music or book
   * @throws ItemNullException - throws exception if the item is not valid (null)
   */
  public void collectItem(LibraryCollection item) throws ItemNullException {
    if (item == null) {
      throw new ItemNullException("Invalid item!");
    }
    this.collectionList.add(item);
  }

  /**
   * removes item from collectionList
   *
   * @param item - a specific item that is removed from the list
   * @throws ItemNotFoundException - throws exception if the item does not exist in the list
   */
  public void removeItem(LibraryCollection item) throws ItemNotFoundException {
    if (this.collectionList.contains(item)) {
      this.collectionList.remove(item);
    } else {
      throw new ItemNotFoundException("Item does not exist!");
    }
  }

  /**
   * search an item by keyword
   *
   * @param keyword - a specific keyword to look up an item
   * @return - a list of items with title containing the keyword
   * @throws ItemNotFoundException - throws exception if the item does not exist in the list
   */
  public ArrayList<LibraryCollection> search(String keyword) throws ItemNotFoundException {
    ArrayList<LibraryCollection> result = new ArrayList<>();
    for (LibraryCollection item : this.collectionList) {
      if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    if (result.isEmpty()) {
      throw new ItemNotFoundException("Item does not exist!");
    }
    return result;
  }

  /**
   * search a book by author
   *
   * @param author - a specific author to search for a book
   * @return a list of books written by a given author
   * @throws ItemNotFoundException - throws exception if the item does not exist in the list
   */
  public ArrayList<LibraryCollection> search(Author author) throws ItemNotFoundException {
    ArrayList<LibraryCollection> result = new ArrayList<>();
    for (LibraryCollection item : this.collectionList) {
      if (item.getCreator().matchedCreator(author)) {
        result.add(item);
      }
    }
    if (result.isEmpty()) {
      throw new ItemNotFoundException("Item does not exist!");
    }
    return result;
  }

  /**
   * search a music by RecordingArtist
   *
   * @param artist - a specific recording artist to search for a music
   * @return a list of musics released by a given recording artist
   * @throws ItemNotFoundException - throws exception if the item does not exist in the list
   */
  public ArrayList<LibraryCollection> search(RecordingArtist artist) throws ItemNotFoundException {
    ArrayList<LibraryCollection> result = new ArrayList<>();
    for (LibraryCollection item : this.collectionList) {
      if (item.getCreator().matchedCreator(artist)) {
        result.add(item);
      }
    }
    if (result.isEmpty()) {
      throw new ItemNotFoundException("Item does not exist!");
    }
    return result;
  }

  /**
   * equals method of Catalog class
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(collectionList, catalog.collectionList);
  }

  /**
   * hashCode method of Catalog class
   */
  @Override
  public int hashCode() {
    return Objects.hash(collectionList);
  }

  /**
   * toString method of Catalog class
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "collectionList=" + collectionList +
        '}';
  }
}