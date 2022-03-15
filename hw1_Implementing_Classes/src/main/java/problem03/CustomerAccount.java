package problem03;

/**
 * CS5004 Spring2022 Jin Young Park HW1 CustomerAccount.java
   CustomerAccount is a class that keeps track of the transfers of an account.
   It includes getIdentifier, getAmount, deposit, withdraw, and conversion to Bitcoins.
 */
public class CustomerAccount {
    private int dollarInAccount;
    private int centInAccount;
    private Identifier userIdentifier;
    private Amount userAmount;
    private final int MAXCENT;
    private final double BTCRATEDOLLAR;
    private final double BTCRATECENT;
    private double bitcoin;
    /**
     * Constructor, creating a new CustomerAccount object, with the provided
       userIdentifier and userAmount.
       MAXCENT is a constant value indicating the maximum value for cent.
       BTCRATEDOLLAR is a constant value indicating rate of bitcoin to a dollar.
       BTCRATECENT is a constant value indicating rate of bitcoin to a cent.
     * @param userAmount - the Amount class with dollar and cent in the customer's account
     * @param userIdentifier - the Identifier class with information of the customer
     */
    public CustomerAccount(Identifier userIdentifier, Amount userAmount) {
        this.userIdentifier = userIdentifier;
        this.userAmount = userAmount;
        MAXCENT = 99;
        BTCRATEDOLLAR = 0.000025;
        BTCRATECENT = 0.00000025;
    }
    /**
     * Returns the userIdentifier.
     * @return the userIdentifier
     */
    public Identifier getUserIdentifier() {
        return userIdentifier;
    }
    /**
     * Returns the userAmount.
     * @return the userAmount
     */
    public Amount getUserAmount() {
        return userAmount;
    }

    /**
     * Computes the amount after deposit the given amounts of dollars and cents
     * from the amount given as a parameter.
     * Returns a new Amount class with computed values of dollars and cents
     * @return newAmount
     */
    public Amount deposit(Amount amountToTransfer) throws Exception {
        centInAccount = amountToTransfer.getCent() + this.userAmount.getCent();
        dollarInAccount = amountToTransfer.getDollar() + this.userAmount.getDollar();
        // take a dollar (100 cents) from the cent value and add 1 to dollar value
        // if cent value after addition is over 99, max cent value.
        if (centInAccount > MAXCENT) {
            centInAccount -= MAXCENT + 1;
            dollarInAccount += 1;
        }
        Amount newAmount = new Amount(dollarInAccount, centInAccount);
        return newAmount;
    }
    /**
     * Computes the amount after withdraw the given amounts of dollars and cents.
     * from the amount given as a parameter.
     * Returns a new Amount class with computed values of dollars and cents
     * @return newAmount
     */
    public Amount withdraw(Amount amountToTransfer) throws Exception {
        centInAccount = userAmount.getCent() - amountToTransfer.getCent();
        dollarInAccount = userAmount.getDollar() - amountToTransfer.getDollar();
        // add a dollar (100 cents) to the cent value and take 1 from dollar value
        // if cent value after subtraction is below 0, the lowest possible value.
        if (centInAccount < 0) {
            centInAccount += MAXCENT + 1;
            dollarInAccount -= 1;
        }
        Amount newAmount = new Amount(dollarInAccount, centInAccount);
        return newAmount;
    }
    /**
     * Converts the dollar and cent values in userAccount into Bitcoin
     * with the given bitcoin conversion rate.
     * Returns bitcoin value in double type.
     * @return bitcoin
     */
    public double convert(Amount userAmount) {
        centInAccount = userAmount.getCent();
        dollarInAccount = userAmount.getDollar();
        bitcoin = centInAccount * BTCRATECENT + dollarInAccount * BTCRATEDOLLAR;
        return bitcoin;
    }
}
