package problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * CS5004 Spring2022 Jin Young Park HW1 TimeTest.java
   TimeTest is a class to test functions in the class Time.
   Includes setHour, setHour, setMinute, setSecond, getHour,
   getMinute, getSecond.
 */
class TimeTest {
    private static Time currentTime;

    /**
     * setup, set up Time objects for testing each function.
     */
    @BeforeEach
    void setUp() throws Exception {
        // exception case 1 and 2 where hour is invalid
        Exception exception = assertThrows(Exception.class, () ->
                currentTime = new Time(25, 20, 25));
        assertEquals("Invalid time.", exception.getMessage());
        Exception exception2 = assertThrows(Exception.class, () ->
                currentTime = new Time(-5, 20, 25));
        assertEquals("Invalid time.", exception2.getMessage());

        // exception case 3 and 4 where minute is invalid
        Exception exception3 = assertThrows(Exception.class, () ->
                currentTime = new Time(5, -20, 25));
        assertEquals("Invalid time.", exception3.getMessage());
        Exception exception4 = assertThrows(Exception.class, () ->
                currentTime = new Time(5, 72, 25));
        assertEquals("Invalid time.", exception3.getMessage());

        // exception case 5 and 6 where second value is invalid
        Exception exception5 = assertThrows(Exception.class, () ->
                currentTime = new Time(5, 20, 81));
        assertEquals("Invalid time.", exception5.getMessage());
        Exception exception6 = assertThrows(Exception.class, () ->
                currentTime = new Time(5, 20, -1));
        assertEquals("Invalid time.", exception6.getMessage());

        // valid case
        currentTime = new Time(16,35,20);
    }

    /**
     * Test if setHour sets the hour with a valid number.
       Checks the value of hour before setting the hour with different value.
       Then checks the value of hour to see if it is changed.
       Also tests exception case
     */
    @Test
    void setHour() throws Exception {
        Assertions.assertEquals(16, currentTime.getHour());
        currentTime.setHour(20);
        Assertions.assertEquals(20, currentTime.getHour());

        // exception case where second is higher than maximum value
        Exception exception = assertThrows(Exception.class, () -> currentTime.setHour(25));
        assertEquals("Invalid time.", exception.getMessage());
        // exception case where second is lower than 0
        Exception exception2 = assertThrows(Exception.class, () -> currentTime.setHour(-5));
        assertEquals("Invalid time.", exception2.getMessage());
    }
    /**
     * Test if setMinute sets the minute with a valid number.
     * Checks the value of minute before setting the minute with different value.
     * Then checks the value of minute to see if it is changed.
     * Also tests exception case
     */
    @Test
    void setMinute() throws Exception {
        Assertions.assertEquals(35, currentTime.getMinute());
        currentTime.setMinute(50);
        Assertions.assertEquals(50, currentTime.getMinute());

        // exception case where second is higher than maximum value
        Exception exception = assertThrows(Exception.class, () -> currentTime.setMinute(-5));
        assertEquals("Invalid time.", exception.getMessage());
        // exception case where second is lower than 0
        Exception exception2 = assertThrows(Exception.class, () -> currentTime.setMinute(78));
        assertEquals("Invalid time.", exception2.getMessage());

    }
    /**
     * Tests if setMinute sets the second with a valid number.
     * Checks the value of second before setting the second with different value.
     * Then checks the value of second to see if it is changed.
     * Also tests exception case
     */
    @Test
    void setSecond() throws Exception {
        Assertions.assertEquals(20, currentTime.getSecond());
        currentTime.setSecond(50);
        Assertions.assertEquals(50, currentTime.getSecond());

        // exception case where second is higher than maximum value
        Exception exception = assertThrows(Exception.class, () -> currentTime.setSecond(61));
        assertEquals("Invalid time.", exception.getMessage());
        // exception case where second is lower than 0
        Exception exception2 = assertThrows(Exception.class, () -> currentTime.setSecond(-50));
        assertEquals("Invalid time.", exception2.getMessage());
    }
    /**
     * Checks getHour returns the correct value.
     */
    @Test
    void getHour() {
        Assertions.assertEquals(16, currentTime.getHour());
    }
    /**
     * Checks getMinute returns the correct value.
     */
    @Test
    void getMinute() {
        Assertions.assertEquals(35, currentTime.getMinute());
    }
    /**
     * Checks getSecond returns the correct value.
     */
    @Test
    void getSecond() {
        Assertions.assertEquals(20, currentTime.getSecond());
    }
}