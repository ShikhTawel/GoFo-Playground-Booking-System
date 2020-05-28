package Classes;

import java.util.Scanner;

public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String username;
    protected String mobileNumber;
    protected Address address;
    protected eWallet ewallet;

    public void updateInfo(int i,String update)
    {
        switch (i)
        {
            case 1:
                firstName=update;
                break;
            case 2:
                lastName=update;
                break;
            case 3:
                email=update;
                break;
            case 4:
                username=update;
                break;
            case 5:
                password=update;
                break;
            case 6:
                mobileNumber=update;
                break;
        }
    }

    public void checkEWallet(){
        System.out.println("Your Balance is: "+ ewallet.getBalance());
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
