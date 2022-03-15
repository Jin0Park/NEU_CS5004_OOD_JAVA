package problem1;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Queue;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testing CourseCatalog class
 */
class CourseCatalogTest {
    private CourseCatalog testCourseCatalog;
    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;

    @BeforeEach
    void setUp() {
        course1 = new Course("Computer Systems", "Sys", 5600);
        course2 = new Course("Foundation of Software Engineering", "SE", 5500);
        course3 = new Course("Building Scalable Distributed Systems", "BSDS", 6650);
        course4 = new Course("Foundations of Artificial Intelligence", "AI", 5100);
        testCourseCatalog = new CourseCatalog(new Course[]{}, -1);
    }

    @Test
    void append() {
        CourseCatalog newCC = new CourseCatalog(new Course[]{course1, course4, course3}, 2);
        testCourseCatalog.append(course1);
        testCourseCatalog.append(course4);
        testCourseCatalog.append(course3);
        assertEquals(newCC, testCourseCatalog);
    }

    @Test
    void add() {
        CourseCatalog newCC = new CourseCatalog(new Course[]{course1, course4, course3}, 2);
        testCourseCatalog.add(course3);
        testCourseCatalog.add(course4);
        testCourseCatalog.add(course1);
        assertEquals(newCC, testCourseCatalog);
    }

    @Test
    void remove() throws CourseNotFoundException {
        CourseCatalog newCC = new CourseCatalog(new Course[]{course4, course3}, 1);
        testCourseCatalog.append(course1);
        testCourseCatalog.append(course4);
        testCourseCatalog.append(course3);
        testCourseCatalog.append(course2);
        testCourseCatalog.remove(course2);
        testCourseCatalog.remove(course1);
        assertEquals(newCC, testCourseCatalog);
        // Throws exception when the course given does not exist
        Exception CourseNotFoundException = assertThrows(Exception.class, () -> testCourseCatalog.remove(course2));
        assertEquals("Invalid Input!", CourseNotFoundException.getMessage());
    }

    @Test
    void contains() {
        assertEquals(false, testCourseCatalog.contains(course2));
        testCourseCatalog.add(course1);
        assertEquals(true, testCourseCatalog.contains(course1));
    }

    @Test
    void indexOf() {
        assertEquals(-1, testCourseCatalog.indexOf(course2));
        testCourseCatalog.add(course1);
        testCourseCatalog.add(course4);
        assertEquals(0, testCourseCatalog.indexOf(course4));
        assertEquals(1, testCourseCatalog.indexOf(course1));
    }

    @Test
    void count() {
        assertEquals(0, testCourseCatalog.count());
        testCourseCatalog.add(course1);
        testCourseCatalog.add(course4);
        assertEquals(2, testCourseCatalog.count());
    }

    @Test
    void get() throws InvalidIndexException {
        testCourseCatalog.add(course1);
        testCourseCatalog.add(course4);
        assertEquals(course4, testCourseCatalog.get(0));
        assertEquals(course1, testCourseCatalog.get(1));
        // Throws exception when the index is not valid
        Exception InvalidIndexException = assertThrows(Exception.class, () -> testCourseCatalog.get(-1));
        assertEquals("Invalid Input!", InvalidIndexException.getMessage());
        Exception InvalidIndexException1 = assertThrows(Exception.class, () -> testCourseCatalog.get(8));
        assertEquals("Invalid Input!", InvalidIndexException1.getMessage());
    }

    @Test
    void isEmpty() {
        assertEquals(true, testCourseCatalog.isEmpty());
        testCourseCatalog.add(course1);
        testCourseCatalog.add(course4);
        assertEquals(false, testCourseCatalog.isEmpty());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testCourseCatalog.equals(testCourseCatalog));
    }

    @Test
    void testEquals_DifferentObject() {
        int[] testContainer = {1, 2, 3};
        Queue newQueue = new Queue(testContainer, 2);
        assertFalse(testCourseCatalog.equals(newQueue));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testCourseCatalog.equals(null));
    }

    @Test
    void testEquals_DifferentElements() {
        Course[] testContainer = {course1, course2};
        CourseCatalog newCourseCatalog = new CourseCatalog(testContainer, 1);
        assertFalse(testCourseCatalog.equals(newCourseCatalog));
    }

    @Test
    void testEquals_DifferentIndex() {
        Course[] testContainer = {};
        CourseCatalog newCourseCatalog = new CourseCatalog(testContainer, 8);
        System.out.println(testCourseCatalog.toString());
        System.out.println(newCourseCatalog.toString());
        assertFalse(testCourseCatalog.equals(newCourseCatalog));
    }

    @Test
    void testHashCode() {
        CourseCatalog newCourseCatalog = new CourseCatalog(new Course[]{}, -1);
        assertTrue(newCourseCatalog.hashCode() == testCourseCatalog.hashCode());
    }

    @Test
    void testToString() {
        String expected = "CourseCatalog{" +
            "courses=" + "[]" +
            ", arraySize=" + "-1" +
            '}';
        assertEquals(expected, testCourseCatalog.toString());
    }
}