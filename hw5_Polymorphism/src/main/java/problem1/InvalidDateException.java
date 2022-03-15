package problem1;

/**
 * Constructs a new exception with the specified detail message when the given date is not valid.
 * The cause is not initialized, and may subsequently be initialized by a call to {@link
 * #initCause}. Prints out the given message.
 */

public class InvalidDateException extends Exception {

  public InvalidDateException(String message) {
    super(message);
  }
}