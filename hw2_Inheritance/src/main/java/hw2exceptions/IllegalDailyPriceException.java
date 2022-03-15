package hw2exceptions;

public class IllegalDailyPriceException extends Exception {
  /**
   * Constructs a new exception with the specified detail message when
   * given daily price integer input is below zero.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public IllegalDailyPriceException(String message) {
    super(message);
  }
}
