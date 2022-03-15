package hw2exceptions;

public class IllegalNumberOfDaysException extends Exception {
  /**
   * Constructs a new exception with the specified detail message when
   * given number of days integer input is below zero.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public IllegalNumberOfDaysException(String message) {
    super(message);
  }
}
