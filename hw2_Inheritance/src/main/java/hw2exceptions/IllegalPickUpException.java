package hw2exceptions;

public class IllegalPickUpException extends Exception {
  /**
   * Constructs a new exception with the specified detail message when
   * given recipient does not match with mail item's recipient or there is nothing in the locker.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public IllegalPickUpException(String message) {
    super(message);
  }
}
