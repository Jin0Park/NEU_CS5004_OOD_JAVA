package problem1;
/**
 * CS5004 Spring2022 Jin Young Park hw4 CourseCatalogInterface.java
 *
 * Interface of CourseCatalog class.
 */
public interface CourseCatalogInterface {
    void append(Course course);
    void add(Course course);
    void remove(Course course) throws CourseNotFoundException;
    Boolean contains(Course course);
    int indexOf(Course course);
    int count();
    Course get(int index) throws InvalidIndexException;
    boolean isEmpty();
}
