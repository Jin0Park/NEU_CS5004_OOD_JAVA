package problem2;

/**
 * Constructs a new exception with the specified detail message when the input item is null. The
 * cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
 * Prints out the given message.
 */

public class ItemNullException extends Exception {

  public ItemNullException(String message) {
    super(message);
  }
}