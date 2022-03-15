package problem03;

/**
 * CS5004 Spring2022 Jin Young Park HW1 Identifier.java
   Identifier is a class that keeps track of the account information of a user.
   The information includes username, year created, country created.
   The information is immutable.
 */
public class Identifier {
    private String username;
    private int yearCreated;
    private String countryCreated;
    /**
     * Constructor, creating a new UserAccount object, with the provided
     username, yearCreated, countryCreated.
     * @param username - the value for username, encoded as String
     * @param yearCreated - the value for year created, encoded as integer
     * @param countryCreated - the value for country created, encoded as String
     */
    public Identifier(String username, int yearCreated, String countryCreated) {
        this.username = username;
        this.yearCreated = yearCreated;
        this.countryCreated = countryCreated;
    }
    /**
     * Returns the username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Returns the year that the account is created.
     * @return the yearCreated
     */
    public int getYearCreated() {
        return yearCreated;
    }
    /**
     * Returns the country where the account is created.
     * @return the countryCreated
     */
    public String getCountryCreated() {
        return countryCreated;
    }
}
