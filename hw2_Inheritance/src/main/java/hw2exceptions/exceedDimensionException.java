package hw2exceptions;

public class exceedDimensionException extends Exception {
  /**
   * Constructs a new exception with the specified detail message when
   * the mail item does not fit into the locker because of its dimensions.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public exceedDimensionException(String message) {
    super(message);
  }
}
