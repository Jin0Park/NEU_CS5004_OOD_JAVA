package problem03;
/**
 * CS5004 Spring2022 Jin Young Park HW1 Amount.java
   Amount is a class that keeps track of the balance in the user's account.
   The class has information of how much dollar and cent are in the account.
   The values are immutable.
 */

public class Amount {
    private int dollar;
    private int cent;
    private final int MAXCENT;

    /**
     * Constructor, creating a new Amount object, with the provided
     dollar and cent values.
     MAXCENT is a constant value indicating the maximum value for cent.
     * @param dollar - the value for dollar, encoded as Integer
     * @param cent - the value for cent, encoded as integer
     * Throws exception if the given dollar or cent is invalid.
     */
    public Amount(int dollar, int cent) throws Exception {
        MAXCENT = 99;
        if (cent < 0 || cent > MAXCENT || dollar < 0) {
            throw new Exception("Wrong amount!");
        } else {
            this.dollar = dollar;
            this.cent = cent;
        }
    }
    /**
     * Returns the dollar amount in the account.
     * @return the dollar
     */
    public int getDollar() {
        return dollar;
    }
    /**
     * Returns the cent amount in the account.
     * @return the cent
     */
    public int getCent() {
        return cent;
    }
}
