package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A {@code User} class is an abstract class used to make generalization for Players and Playground Owners in the system.
 * A User has a firstName, lastName, email, username, password and a type, whether a Player of Playground Owner
 */
public abstract class User{
    /**
     * the first name of the user
     */
    protected String firstName;
    /**
     * the last name of the user
     */
    protected String lastName;
    /**
     * the email of the user
     */
    protected String email;
    /**
     * the username of the user
     */
    protected String username;
    /**
     * the password of the user
     */
    protected String password;
    /**
     * the type of account, whether Player or PlaygroundOwner
     */
    protected String type;
    protected Scanner in = new Scanner(System.in);

    /**
     * A Constructor for the User class
     * @param fn the first name of the user
     * @param ln the last name of the user
     * @param mail the email of the user
     * @param un the username of the user
     * @param pw the password of the user
     * @param tp the type of account, whether Player or PlaygroundOwner
     */
    public User(String fn, String ln, String mail, String un, String pw, String tp) {
        firstName = fn;
        lastName = ln;
        email = mail;
        username = un;
        password = pw;
        type = tp;
    }

    /**
     * A method to be overriden by the subclasses in order to display a list of operations
     * @param playgrounds playgrounds available in the system
     */
    public void operations(ArrayList<Playground> playgrounds) {

    }

    /**
     * Gets the first name of the user
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of the user
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the username of the user
     * @return username String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user
     * @return password String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
