package problem2;

/**
 * Constructs a new exception with the specified detail message when there is no matching item in
 * the collection. The cause is not initialized, and may subsequently be initialized by a call to
 * {@link #initCause}. Prints out the given message.
 */

public class ItemNotFoundException extends Exception {

  public ItemNotFoundException(String message) {
    super(message);
  }
}