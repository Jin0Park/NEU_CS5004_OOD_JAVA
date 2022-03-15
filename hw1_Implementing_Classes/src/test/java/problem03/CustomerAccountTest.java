package problem03;

/**
 * CS5004 Spring2022 Jin Young Park HW1 CustomerAccountTest.java
 CustomerAccountTest is a class to test functions in the class CustomerAccount.
 Includes getIdentifier, getAmount, deposit, withdraw, convert.
 Tests two different cases.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CustomerAccountTest {
    private static Identifier firstCustomerIdentifier;
    private static Amount firstCustomerAmount;
    private static Amount firstAmountTransfer;
    private static CustomerAccount firstCustomerAccount;
    private static Identifier secondCustomerIdentifier;
    private static Amount secondAmountTransfer;
    private static Amount secondCustomerAmount;
    private static CustomerAccount secondCustomerAccount;

    /**
     * setup, set up Identifier, Amount, and CustomerAccount objects for testing each function.
     */
    @BeforeEach
    void setUp() throws Exception {
        firstCustomerIdentifier = new Identifier("dominic", 2012, "USA");
        firstCustomerAmount = new Amount(500, 60);
        firstCustomerAccount = new CustomerAccount(firstCustomerIdentifier, firstCustomerAmount);
        secondCustomerIdentifier = new Identifier("TonyStarkFE", 1980, "Mexico");
        secondCustomerAmount = new Amount(1230000, 58);
        secondCustomerAccount = new CustomerAccount(secondCustomerIdentifier, secondCustomerAmount);
        // Amount classes for deposit and withdraw functions.
        firstAmountTransfer = new Amount(70, 70);
        secondAmountTransfer = new Amount(12000, 20);
    }
    /**
     * Checks getIdentifier returns the correct value.
     */
    @Test
    void getIdentifier() {
        // first case
        Assertions.assertEquals("dominic", firstCustomerAccount.getUserIdentifier().getUsername());
        Assertions.assertEquals(2012, firstCustomerAccount.getUserIdentifier().getYearCreated());
        Assertions.assertEquals("USA", firstCustomerAccount.getUserIdentifier().getCountryCreated());
        // second case
        Assertions.assertEquals("TonyStarkFE", secondCustomerAccount.getUserIdentifier().getUsername());
        Assertions.assertEquals(1980, secondCustomerAccount.getUserIdentifier().getYearCreated());
        Assertions.assertEquals("Mexico", secondCustomerAccount.getUserIdentifier().getCountryCreated());
    }
    /**
     * Checks getAmount returns the correct value.
     */
    @Test
    void getAmount() {
        // first case
        Assertions.assertEquals(500, firstCustomerAccount.getUserAmount().getDollar());
        Assertions.assertEquals(60, firstCustomerAccount.getUserAmount().getCent());
        // second case
        Assertions.assertEquals(1230000, secondCustomerAccount.getUserAmount().getDollar());
        Assertions.assertEquals(58, secondCustomerAccount.getUserAmount().getCent());
    }
    /**
     * Test if deposit function computes the amount deposited correctly.
     * Checks the value of dollar and cent of the changed amount.
     */
    @Test
    void deposit() throws Exception {
        Assertions.assertEquals(571, firstCustomerAccount.deposit(firstAmountTransfer).getDollar());
        Assertions.assertEquals(30, firstCustomerAccount.deposit(firstAmountTransfer).getCent());
        Assertions.assertEquals(1242000, secondCustomerAccount.deposit(secondAmountTransfer).getDollar());
        Assertions.assertEquals(78, secondCustomerAccount.deposit(secondAmountTransfer).getCent());

    }
    /**
     * Test if withdraw function computes the amount withdrew correctly.
     * Checks the value of dollar and cent of the changed amount.
     */
    @Test
    void withdraw() throws Exception {
        // first case
        Assertions.assertEquals(429, firstCustomerAccount.withdraw(firstAmountTransfer).getDollar());
        Assertions.assertEquals(90, firstCustomerAccount.withdraw(firstAmountTransfer).getCent());
        // second case
        Assertions.assertEquals(1218000, secondCustomerAccount.withdraw(secondAmountTransfer).getDollar());
        Assertions.assertEquals(38, secondCustomerAccount.withdraw(secondAmountTransfer).getCent());
    }
    /**
     * Test if convert function computes the conversion to Bitcoins correctly.
     */
    @Test
    void convert() {
        // first case
        Assertions.assertEquals(0.0125, firstCustomerAccount.convert(firstCustomerAmount), 0.001);
        // second case
        Assertions.assertEquals(30.75, secondCustomerAccount.convert(secondCustomerAmount), 0.001);
    }

}