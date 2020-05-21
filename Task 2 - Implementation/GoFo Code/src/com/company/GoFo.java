package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A {@code GoFo} object is the base of the system, it contains all the users and playgrounds stored in the system and allows for signing up and logging in to a certain account
 */
public class GoFo {
    /**
     * An ArrayList of all the users in the system, whether a Player or a PlaygroundOwner
     */
    protected ArrayList<User> users = new ArrayList<User>();
    /**
     * An ArrayList of all the playgrounds in the system
     */
    protected ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    protected Scanner in = new Scanner(System.in);

    /**
     * A Constructor for the GoFo object.
     * it creates a default {@code Player} object with username: player and password: player1234
     * and creates a default {@code PlaygroundOwner} object with username: owner and password: owner1234
     */
    public GoFo() {
        users.add(new PlaygroundOwner("owner", "owner", "owner@example.com", "owner", "owner1234"));
        users.add(new Player("player", "player", "player@example.com", "player", "player1234"));
    }

    /**
     * A main menu for any user to choose to sign up a new account or log in to his existing account
     */
    public void menu() {
        System.out.println("\n-----------------------Welcome to GoFo playgrounds booking system-------------------------");
        System.out.println("1- Signup a new user" +
                "\n2- Login" +
                "\n3- Exit");
        int option = in.nextInt();
        if (option == 1) {
            signUp();
            menu();
        } else if (option == 2) {
            login();
            menu();
        } else if (option == 3) {
            return;
        } else {
            System.out.println("Invalid Option, please try again");
            menu();
            return;
        }
    }

    /**
     * A method to sign up a new user using his first name, last name, email, username, password and account type
     */
    public void signUp() {
        System.out.println("\n--------------------------Sign Up------------------------------");
        String firstName, lastName, email, password, username;
        System.out.print("Enter first name: ");
        in.skip("\n");
        firstName = in.nextLine();
        System.out.print("Enter last name: ");
        lastName = in.nextLine();
        System.out.print("Enter Email: ");
        email = in.nextLine();
        for (int i = 0; i < users.size(); i++) { //checks if the email is already registered
            if (users.get(i).getEmail().equalsIgnoreCase(email)) {
                System.out.println("This email is already registered");
                return;
            }
        }
        System.out.print("Enter Username: ");
        username = in.nextLine();
        for (int i = 0; i < users.size(); i++) { //checks if the username is already taken
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                System.out.println("This username is taken, please enter another username: ");
                username = in.nextLine();
                i = -1;
            }
        }
        System.out.print("Enter Password\n(more than 7 characters and must include letters and numbers): ");
        password = in.nextLine();
        while (!isStrong(password)) { //checks if the password is strong or not
            System.out.println("Password is not Strong, please try another password");
            System.out.println("Enter Password (more than 7 characters and must include letters and numbers): ");
            password = in.nextLine();
        }
        int type;
        System.out.println("What is the type of account ?" +
                "\n1- Player" +
                "\n2- Playground Owner");
        type = in.nextInt();
        while (type != 2 && type != 1) {
            System.out.println("Invalid option, please try again");
            System.out.println("What is the type of account ?" +
                    "\n1- Player" +
                    "\n2- Playground Owner");
            type = in.nextInt();
        }
        if (type == 1) { //create a new player object
            users.add(new Player(firstName, lastName, email, username, password));
        } else { //create a new playground owner object
            users.add(new PlaygroundOwner(firstName, lastName, email, username, password));
        }
    }

    /**
     * A method that indicates whether password is Strong enough or not, a strong password contains letters and numbers and is at least 7 characters
     * @param password password to be tested
     * @return boolean indicating whether the password is Strong
     */
    public boolean isStrong(String password) {
        if (password.length() < 7) { // a strong password must be at least 7 characters
            return false;
        }
        boolean containsLetter = false;
        boolean containsNumber = false; // a strong password must include letters and numbers
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= 'a' && password.charAt(i) <= 'z') || (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')) {
                containsLetter = true;
            } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                containsNumber = true;
            }
            if (containsLetter && containsNumber) break;
        }
        if (!containsLetter || !containsNumber) {
            return false;
        }
        return true;
    }

    /**
     * A method to allow user to log in to his existing account using username or email and Password, whether he is a Player of Playground Owner
     */
    public void login() {
        System.out.println("\n==================================================");
        System.out.print("Enter username or email: ");
        in.skip("\n");
        String usernameOrEmail = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        System.out.println("==================================================");
        for (int i = 0; i < users.size(); i++) { //matches the inputted data with the users data in the system
            if (users.get(i).getUsername().equalsIgnoreCase(usernameOrEmail) || users.get(i).getEmail().equalsIgnoreCase(usernameOrEmail)) {
                if (users.get(i).getPassword().equals(password)) {
                    users.get(i).operations(playgrounds);
                    return;
                }
            }
        }
        // if we failed to find the specified username or password is incorrect
        System.out.println("Username or password is incorrect!");
    }
}
