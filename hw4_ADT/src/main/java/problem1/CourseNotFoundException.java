package problem1;
/**
 * Constructs a new exception with the specified detail message when
 * the given course input does not exist in the Course Catalog.
 * The cause is not initialized, and may subsequently be initialized by a
 * call to {@link #initCause}.
 * Prints out the given message.
 */
public class CourseNotFoundException extends Exception{
    public CourseNotFoundException(String message){
        super(message);
    }
}
