package problem1;

import java.util.Arrays;
import java.util.Objects;
/**
 * CS5004 Spring2022 Jin Young Park hw4 CourseCatalog.java
 *
 * Using an array, CourseCatalog stores course elements.
 * It contains append, add, remove, contains, indexOf, count, get, and isEmpty methods.
 */
public class CourseCatalog implements CourseCatalogInterface{
    private Course[] courses;
    private int arraySize = -1;

    /**
     * Constructor of CourseCatalog
     * @param courses - an array with course elements.
     * @param arraySize - the size of the array
     */
    public CourseCatalog(Course[] courses, int arraySize) {
        this.courses = courses;
        this.arraySize = arraySize;
    }

    @Override
    /**
     * Adds a Course to the end of the CourseCatalog
     */
    public void append(Course course) {
        this.arraySize += 1;
        Course newarr[] = new Course[this.arraySize + 1];
        int i;
        for (i=0; i < this.arraySize; i++){
            newarr[i] = this.courses[i];
        }
        newarr[this.arraySize] = course;
        this.courses = newarr;
    }

    @Override
    /**
     * Adds a Course to the beginning of the CourseCatalog.
     */
    public void add(Course course) {
        this.arraySize += 1;
        Course newarr[] = new Course[this.arraySize + 1];
        int i;
        for (i=0; i < this.arraySize; i++){
            newarr[i+1] = this.courses[i];
        }
        newarr[0] = course;
        this.courses = newarr;
    }

    @Override
    /**
     * Removes a specified Course from the CourseCatalog.
     * Throw a CourseNotFoundException if the Course does not exist. If the
     * CourseCatalog contains multiple instances of the same Course, the instance with the
     * lowest index is removed.
     */
    public void remove(Course course) throws CourseNotFoundException {
        if(!contains(course))
            throw new CourseNotFoundException("Invalid Input!");

        Course newarr[] = new Course[this.courses.length-1];
        boolean removed = false;
        int i = 0;
        while (i < this.courses.length-1) {
            if(removed == false && this.courses[i].equals(course)) {
                removed = true;
                i -= 1;
            } else {
                if (removed == false) {
                    newarr[i] = this.courses[i];
                } else {
                    newarr[i] = this.courses[i + 1];
                }
            }
            i += 1;
        }
        this.courses = newarr;
        this.arraySize -= 1;
    }

    @Override
    /**
     * Checks if the specified course exists in the CourseCatalog.
     */
    public Boolean contains(Course course) {
        if (indexOf(course) == -1) {
            return false;
        }
        return true;
    }

    @Override
    /**
     * Returns the index of the specified Course in the CourseCatalog, if it exists.
     * If the Course doesn’t exist, returns -1.
     */
    public int indexOf(Course course) {
        for (int i=0; i <= this.arraySize; i++) {
            if (this.courses[i].equals(course)){
                return i;
            }
        }
        return -1;
    }

    @Override
    /**
     * Gets the number of Courses in the CourseCatalog.
     */
    public int count() {
        return this.arraySize+1;
    }

    @Override
    /**
     * Returns the Course at the given index in the CourseCatalog.
     * Throws an InvalidIndexException if the index doesn’t exist.
     */
    public Course get(int index) throws InvalidIndexException {
        if (index < 0 || index > this.count() - 1) {
            throw new InvalidIndexException("Invalid Input!");
        }
        return this.courses[index];
    }

    @Override
    /**
     * Checks if the CourseCatalog is empty.
     */
    public boolean isEmpty() {
        return (this.arraySize == -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseCatalog that = (CourseCatalog) o;
        return arraySize == that.arraySize && Arrays.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(arraySize);
        result = 31 * result + Arrays.hashCode(courses);
        return result;
    }

    @Override
    public String toString() {
        return "CourseCatalog{" +
            "courses=" + Arrays.toString(courses) +
            ", arraySize=" + arraySize +
            '}';
    }
}
