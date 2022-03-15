package problem2;

/**
 * Constructs a new exception with the specified detail message when the given park to be added
 * already exists in the list. The cause is not initialized, and may subsequently be initialized by
 * a call to {@link #initCause}. Prints out the given message.
 */

public class NationalParkAlreadyExistException extends Exception {

  public NationalParkAlreadyExistException(String message) {
    super(message);
  }
}