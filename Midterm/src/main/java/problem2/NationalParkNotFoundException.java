package problem2;

/**
 * Constructs a new exception with the specified detail message when the given park does not exist
 * in the collection. The cause is not initialized, and may subsequently be initialized by a call to
 * {@link #initCause}. Prints out the given message.
 */

public class NationalParkNotFoundException extends Exception {

  public NationalParkNotFoundException(String message) {
    super(message);
  }
}