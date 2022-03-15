package problem1;
/**
 * Constructs a new exception with the specified detail message when
 * the given number input exceeds the course catalog index or negative.
 * The cause is not initialized, and may subsequently be initialized by a
 * call to {@link #initCause}.
 * Prints out the given message.
 */

public class InvalidIndexException extends Exception{
    public InvalidIndexException(String message){
        super(message);
    }
}
