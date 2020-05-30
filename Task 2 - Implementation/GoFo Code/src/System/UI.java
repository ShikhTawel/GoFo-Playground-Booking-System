package src.System;

import src.Playground.Playground;
import src.Playground.TimeSlot;

import java.util.Random;
import java.util.Scanner;

public final class UI implements MainMenu{

    private Scanner scanner = new Scanner(System.in);

    public UI() {
        String option = "";
        System.out.println("Enter an option");
        while (true) {
            System.out.print("LogIn(1)/SignUp(2): ");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                login();
            } else if (option.equalsIgnoreCase("2")) {
                sighUp();
            } else {
                System.out.println("***Enter valid option***\n");
            }
        }
    }

    @Override
    public void mainMenu() {

    }

    private void sighUp() {
        String username = "";
        String password = "";

        String address;
        String phone;
        String email;
        String firstName;
        String lastName;


        while (true) {
            System.out.print("Enter new username: ");
            username = scanner.nextLine();
            boolean validUsername = checkUsername(username);
            if (!validUsername) {
                System.out.println("***Username already taken***\n");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter new password (at least 8 letters, include 1 symbol and 1 Uppercase letter): ");
            password = scanner.nextLine();
            boolean validPassword = checkStrongPassword(password);
            if (!validPassword) {
                System.out.println("***Enter strong password***\n");
            } else {
                break;
            }
        }
        // Add new user to the pool
    }

    private void login() {
        String username;
        String password;
        boolean foundUser = false;
        boolean correctPassword = false;
        while (true) {
            do {
                System.out.print("Enter Username: ");
                username = scanner.nextLine();
                System.out.print("Enter Password: ");
                password = scanner.nextLine();

                // validate username and password;

                if (!foundUser) {
                    System.out.println("***Username not found***\n");
                }
            } while (!foundUser);

            if (!correctPassword) {
                System.out.println("***Enter valid password***\n");
                continue;
            } else {
                break;
            }
        }
        System.out.println("Login successfully");
    }

    private void logout() {

    }

    private boolean checkStrongPassword(String password) {
        boolean strong = false;
        if (password.length() < 8) {
            return strong;
        }
        int symbols = 0;
        int uppercase = 0;
        for (int i = 0; i < password.length(); ++i) {
            if (Character.isLetterOrDigit(password.charAt(i))) {
                if (Character.isUpperCase(password.charAt(i))) {
                    ++uppercase;
                }
            } else {
                ++symbols;
            }
        }
        if (symbols >= 1 && uppercase >= 1) {
            strong = true;
        }

        return strong;
    }

    private boolean checkEmail(String email) {
        boolean validEmail;

        validEmail = email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
                "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        takenEmail();
        return validEmail;
    }
    private boolean takenEmail() {
        //check if the mail already signed up

        return false;
    }

    private boolean checkUsername(String username) {
        boolean existsUsername = false;
        // if not exist make true
        return existsUsername;
    }

    private void sendEmailVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(100000);
        String message = String.format("Your account verification code is %d", code);
        System.out.println("Check your inbox for verification code.");
        int userCode = scanner.nextInt();
        System.out.println("Verified");
    }
}



