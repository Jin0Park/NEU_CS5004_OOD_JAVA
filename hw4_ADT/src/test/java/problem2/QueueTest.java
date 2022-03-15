package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import problem1.Course;
import problem1.CourseCatalog;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testing Queue class
 */
class QueueTest {
    private Queue testQueue;

    @BeforeEach
    void setUp() {
        int[] testContainer = {1, 2, 3, 4, 5};
        testQueue = new Queue(testContainer, 4);
    }

    @Test
    void getIndex() {
        assertEquals(4, testQueue.getIndex());
        assertEquals(-1, testQueue.emptyQueue().getIndex());
    }

    @Test
    void emptyQueue() {
        int[] newContainer = new int[10];
        Queue empty = new Queue(newContainer, -1);
        assertEquals(empty, testQueue.emptyQueue());
    }

    @Test
    void isEmpty() {
        assertEquals(true, testQueue.emptyQueue().isEmpty());
        assertEquals(false, testQueue.isEmpty());
    }

    @Test
    void add() {
        int[] newContainer = {1, 2, 3, 4, 5, 8};
        Queue newQueue = new Queue(newContainer, 5);
        assertEquals(newQueue, testQueue.add(8));
    }

    @Test
    void contains() {
        assertEquals(true, testQueue.contains(2));
        assertEquals(false, testQueue.contains(8));
    }

    @Test
    void remove() {
        int[] newContainer = {2, 3, 4, 5};
        Queue newQueue = new Queue(newContainer, 3);
        assertEquals(newQueue, testQueue.remove());
    }

    @Test
    void removeElement() {
        int[] newContainer = {2, 3, 4, 5};
        Queue newQueue = new Queue(newContainer, 3);
        assertEquals(newQueue, testQueue.removeElement(1));
        int[] newNewContainer = {1, 2, 3, 4, 5};
        Queue newNewQueue = new Queue(newNewContainer, 4);
        assertEquals(newNewQueue, testQueue.removeElement(8));
    }

    @Test
    void size() {
        assertEquals(5, testQueue.size());
        assertEquals(4, testQueue.remove().size());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testQueue.equals(testQueue));
    }

    @Test
    void testEquals_DifferentObject() {
        Course[] testContainer = {};
        CourseCatalog newCourseCatalog = new CourseCatalog(testContainer, -1);
        assertFalse(testQueue.equals(newCourseCatalog));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testQueue.equals(null));
    }

    @Test
    void testEquals_DifferentElements() {
        int[] testContainer = {1, 2, 3, 5, 13};
        Queue newQueue = new Queue(testContainer, 4);
        assertFalse(testQueue.equals(newQueue));
    }

    @Test
    void testEquals_DifferentIndex() {
        int[] testContainer = {1, 2, 3, 4, 5};
        Queue newQueue = new Queue(testContainer, 0);
        assertFalse(testQueue.equals(newQueue));
    }

    @Test
    void testHashCode() {
        int[] testContainer = {1, 2, 3, 4, 5};
        Queue newQueue = new Queue(testContainer, 4);
        assertTrue(newQueue.hashCode() == testQueue.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Queue{" +
                "container=" + "[1, 2, 3, 4, 5]" +
                ", index=" + "4" +
                '}';
        assertEquals(expected, testQueue.toString());
    }
}