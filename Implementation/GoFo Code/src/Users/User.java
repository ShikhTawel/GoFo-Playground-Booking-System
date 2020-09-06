package src.Users;
import src.Utilities.Address;
import src.Utilities.eWallet;

/**
 * A {@code User} class is an abstract class used to make generalization for Players and Playground Owners in the system.
 */
public abstract class User {
    /**
     * The first name of the user
     */
    protected String firstName;
    /**
     * The last name of the user
     */
    protected String lastName;
    /**
     * The email of the user
     */
    protected String email;
    /**
     * The password of the user
     */
    protected String password;
    /**
     * The username of the user, it's the identifying attribute of the {@code User} object
     */
    protected String username;
    /**
     * The mobile phone number of the user
     */
    protected String mobileNumber;
    /**
     * The address of the user
     */
    protected Address address;
    /**
     * the eWallet of the user, used to make money transactions between different users
     */
    protected eWallet ewallet;

    /**
     * A constructor for the {@code User} object
     * @param fn first name
     * @param ln last name
     * @param em email
     * @param pass password
     * @param un username
     * @param mn mobile number
     * @param ad address
     */
    public User(String fn, String ln, String em, String pass, String un, String mn, Address ad) {
        firstName = fn;
        lastName = ln;
        email = em;
        password = pass;
        username = un;
        mobileNumber = mn;
        address = ad;
        ewallet = new eWallet();
    }

    /**
     * Prints the current balance of the user's eWallet
     */
    public void checkEWallet() {
        System.out.println("Your Balance is: " + ewallet.getBalance());
    }

    /**
     * Gets the first name of the user
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the uesr
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of the user
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the username of the user
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the mobile number of the user
     * @return the mobile number
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Sets the mobile number of the user
     * @param mobileNumber the new mobile number
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Gets the address of the user
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the user
     * @param address the new address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the eWallet of the user
     * @return the eWallet
     */
    public eWallet getEwallet() {
        return ewallet;
    }
}
