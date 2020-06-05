package src.System;

import src.Users.*;

import java.util.Scanner;

/**
 * {@code eWalletUI} class is used to enable users to access their eWallets and do operations on them
 */
public class eWalletUI {
    private User user;
    Scanner scanner = new Scanner(System.in);

    /**
     * A constructor for the {@code eWalletUI} object
     * @param user the current user logged into the system
     */
    public eWalletUI(User user) {
        this.user = user;
        mainMenu();
    }

    /**
     * A main menu that allows a user to do choose an operation to be done on their eWallets
     */
    public void mainMenu() {
        String option = "";
        System.out.println("Enter an option");
        while (true) {
            System.out.println("\n1- View Current Balance" +
                    "\n2- Deposit" +
                    "\n3- Withdraw" +
                    "\n4- Exit");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("1")) {
                viewBalance();
            } else if (option.equalsIgnoreCase("2")) {
                deposit();
            } else if (option.equalsIgnoreCase("3")) {
                withdraw();
            } else if (option.equalsIgnoreCase("4")) {
                break;
            } else {
                System.out.println("***Enter valid option***\n");
            }
        }
        System.out.println("\nExiting ...");
    }

    /**
     * Outputs the current balance of the user's eWallet
     */
    public void viewBalance() {
        System.out.println("Your Current Balance is: " + user.getEwallet().getBalance());
    }

    /**
     * Allows users to deposit to their eWallet accounts by entering the amount
     */
    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount;
        amount = scanner.nextDouble();
        scanner.skip("\n");
        if (user.getEwallet().deposit(amount)) {
            System.out.println("Deposited " + amount + " successfully");
        } else {
            System.out.println("Invalid amount to deposit");
        }
    }

    /**
     * Allows users to withdraw from their eWallet accounts by entering the amount
     */
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount;
        amount = scanner.nextDouble();
        scanner.skip("\n");
        if (user.getEwallet().withdraw(amount)) {
            System.out.println("Withdrew " + amount + " successfully");
        } else {
            System.out.println("Invalid amount to withdraw");
        }
    }
}
