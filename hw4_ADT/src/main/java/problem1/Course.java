package problem1;
import java.util.Objects;
/**
 * CS5004 Spring2022 Jin Young Park hw4 Course.java
 *
 * Course class stores information about each course.
 */
public class Course {
    private final String name;
    private final String prefix;
    private final int number;
    public Course(String name, String prefix, int number) {
        this.name = name;
        this.prefix = prefix;
        this.number = number;
    }

    @Override
    /**
     * toString method of Course
     */
    public String toString() {
        return prefix + number + ": " + name;
    }
    @Override
    /**
     * equals method of Course
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return number == course.number &&
                name.equals(course.name) &&
                prefix.equals(course.prefix);
    }
    @Override
    /**
     * hashCode method of Course
     */
    public int hashCode() {
        return Objects.hash(name, prefix, number);
    }
}