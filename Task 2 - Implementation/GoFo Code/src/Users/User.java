package src.Users;
import src.Utilities.Address;
import src.Utilities.eWallet;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String username;
    protected String mobileNumber;
    protected Address address;
    protected eWallet ewallet;

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

    public void checkEWallet() {
        System.out.println("Your Balance is: " + ewallet.getBalance());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEwallet(eWallet ewallet) {
        this.ewallet = ewallet;
    }

    public eWallet getEwallet() {
        return ewallet;
    }
}
