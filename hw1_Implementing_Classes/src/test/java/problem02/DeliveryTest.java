package problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CS5004 Spring2022 Jin Young Park HW1 DeliveryTest.java
   DeliveryTest is a class to test functions in the class Delivery.
   Includes getStartLoc, getEndLoc, setStartLoc, setEndLoc, getDuration.
 */
class DeliveryTest {
    private Time firstTimeStarted;
    private Time firstTimeEnded;
    private Time secondTimeStarted;
    private Time secondTimeEnded;
    private Delivery firstTestDelivery;
    private Delivery secondTestDelivery;

    /**
     * setup, set up Time objects and Delivery object for testing each function.
     */
    @BeforeEach
    void setUp() throws Exception {
        // Delivery case where end time is past midnight, and end hour/min/sec are lower than start hour/min/sec
        firstTimeStarted = new Time(23, 7, 15);
        firstTimeEnded = new Time(3, 5, 8);
        firstTestDelivery = new Delivery("Seattle", "Bellevue", firstTimeStarted, firstTimeEnded);
        // Delivery case where end hour/min/sec are higher than start hour/min/sec
        secondTimeStarted = new Time(15, 7, 15);
        secondTimeEnded = new Time(15, 15, 25);
        secondTestDelivery = new Delivery("Seattle", "Downtown", secondTimeStarted, secondTimeEnded);

    }
    /**
     * Checks getStartLoc returns the correct value.
     */
    @Test
    void getStartLoc() {
        Assertions.assertEquals("Seattle", firstTestDelivery.getStartLoc());
    }

    /**
     * Test if setStartLoc sets the startLoc correctly.
     * Checks the value of startLoc, and sets the startLoc with different value.
     * Then checks the value of startLoc to see if it is changed.
     */
    @Test
    void setStartLoc() {
        Assertions.assertEquals("Seattle", firstTestDelivery.getStartLoc());
        firstTestDelivery.setStartLoc("Lynnwood");
        Assertions.assertEquals("Lynnwood", firstTestDelivery.getStartLoc());
    }

    /**
     * Checks getSecond returns the correct value.
     */
    @Test
    void getEndLoc() {
        Assertions.assertEquals("Bellevue", firstTestDelivery.getEndLoc());
    }

    /**
     * Test if setSecond sets the second with a valid number.
     * Checks the value of second, and sets the second with different value.
     * Then checks the value of second to see if it is changed.
     */
    @Test
    void setEndLoc() {
        Assertions.assertEquals("Bellevue", firstTestDelivery.getEndLoc());
        firstTestDelivery.setEndLoc("Kirkland");
        Assertions.assertEquals("Kirkland", firstTestDelivery.getEndLoc());
    }

    /**
     * Test if getDuration computes the correct time duration from
     * start time and end time.
     */
    @Test
    void getDuration() throws Exception {
        // first delivery case
        Time firstTimeDuration = new Time(3, 57, 53);
        Assertions.assertEquals(firstTimeDuration.getHour(), firstTestDelivery.getDuration().getHour());
        Assertions.assertEquals(firstTimeDuration.getMinute(), firstTestDelivery.getDuration().getMinute());
        Assertions.assertEquals(firstTimeDuration.getSecond(), firstTestDelivery.getDuration().getSecond());
        // second delivery case
        Time secondTimeDuration = new Time(0, 8, 10);
        Assertions.assertEquals(secondTimeDuration.getHour(), secondTestDelivery.getDuration().getHour());
        Assertions.assertEquals(secondTimeDuration.getMinute(), secondTestDelivery.getDuration().getMinute());
        Assertions.assertEquals(secondTimeDuration.getSecond(), secondTestDelivery.getDuration().getSecond());
    }
}
