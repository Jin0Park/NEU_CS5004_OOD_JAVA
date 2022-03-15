package hw2exceptions;

public class lockerOccupiedException extends Exception {
  /**
   * Constructs a new exception with the specified detail message when
   * the locker is occupied.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public lockerOccupiedException(String message) {
    super(message);
  }
}
