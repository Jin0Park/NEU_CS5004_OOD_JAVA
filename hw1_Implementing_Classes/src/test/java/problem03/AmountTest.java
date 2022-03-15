package problem03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * CS5004 Spring2022 Jin Young Park HW1 AmountTest.java
   AmountTest is a class to test functions in the class Amount.
   Includes getDollar and getCent.
 */

class AmountTest {
    private static Amount testAmount;

    /**
     * setup, set up Amount object for testing each function.
     */
    @BeforeEach
    void setUp() throws Exception {
        // exception case 1 where dollar value is below zero
        Exception exception = assertThrows(Exception.class, () -> testAmount = new Amount(-50, 20));
        assertEquals("Wrong amount!", exception.getMessage());
        // exception case 2 where cent is higher than 99 which is the maximum cent value
        Exception exception2 = assertThrows(Exception.class, () -> testAmount = new Amount(50, 150));
        assertEquals("Wrong amount!", exception2.getMessage());
        // exception case 3 where cent value is below zero
        Exception exception3 = assertThrows(Exception.class, () -> testAmount = new Amount(60, -80));
        assertEquals("Wrong amount!", exception3.getMessage());

        // valid case
        testAmount = new Amount(500, 50);
    }
    /**
     * Test if getDollar returns the correct dollar value.
     */
    @Test
    void getDollar() {
        Assertions.assertEquals(500, testAmount.getDollar());
    }
    /**
     * Test if getCent returns the correct cent value.
     */
    @Test
    void getCent() {
        Assertions.assertEquals(50, testAmount.getCent());
    }
}