package problem01;

/**
 * CS5004 Spring2022 Jin Young Park HW1 User.java
   User is a simple class that keeps track of information of a user.
   The information includes the user's firstname, lastname, phone number,
   email address, and credential pairs.
   Phone number should be 10 digits.
 */
public class User {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String emailAddress;
    private Credentials credentialPair;
    private final int PHONENUMLENGTH;

    /**
     * Constructor, creating a new User object, with the provided
     firstname, lastname, phoneNumber, emailAddress, and credentialPair.
     * @param firstname - the value for firstname, encoded as String
     * @param lastname - the value for lastname, encoded as String
     * @param phoneNumber - the value for phone number, encoded as String
     *                      should be 10 digits. Otherwise, throws exception.
     * @param emailAddress - the value for email address, encoded as String
     * @param credentialPair - the credentialPair from Credentials class.
     */
    public User(String firstname, String lastname, String phoneNumber,
                String emailAddress, Credentials credentialPair) throws Exception {
        PHONENUMLENGTH = 10;
        this.firstname = firstname;
        this.lastname = lastname;
        if (phoneNumber.length() == PHONENUMLENGTH) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new Exception ("The given phone number is not valid.");
        }
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.credentialPair = credentialPair;
    }

    /**
     * Sets firstname to the given firstname.
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Sets lastname to the given lastname.
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Sets phoneNumber to the given phoneNumber.
     * Throws exception if the given phone number is invalid.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber.length() == PHONENUMLENGTH) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new Exception("The given phone number is not valid.");
        }
    }

    /**
     * Sets emailAddress to the given emailAddress.
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Sets credentialPair to the given credentialPair.
     * @param credentialPair
     */
    public void setCredentialPair(Credentials credentialPair) {
        this.credentialPair = credentialPair;
    }

    /**
     * Returns firstname.
     * @return firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Returns lastname.
     * @return lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Returns phoneNumber.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns emailAddress.
     * @return emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Returns credentialPair.
     * @return credentialPair
     */
    public Credentials getCredentialPair() {
        return credentialPair;
    }
}
