package problem2;

/**
 * Constructs a new exception with the specified detail message when there is no matching band
 * member when trying to remove the band member. The cause is not initialized, and may subsequently
 * be initialized by a call to {@link #initCause}. Prints out the given message.
 */

public class BandMemberNotFoundException extends Exception {

  public BandMemberNotFoundException(String message) {
    super(message);
  }
}