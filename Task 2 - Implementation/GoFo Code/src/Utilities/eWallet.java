package src.Utilities;

import src.Users.User;

import java.util.Scanner;

/**
 * A {@code eWallet} class is used to call an external service to transfer money between different users in the system
 */
public class eWallet {
    /**
     * the current balance of the user's account
     */
    private double currentBalance;

    /**
     * A constructor for the {@code eWallet} object
     */
    public eWallet() {
        currentBalance = 0;
    }

    /**
     * Deposits an amount to the user's account
     * @param amount the amount to be deposited
     * @return whether successful or not
     */
    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        currentBalance += amount;
        return true;
    }

    /**
     * Withdraws an amount from the user's account
     * @param amount the amount to be withdrawn
     * @return whether successful or not
     */
    public boolean withdraw(double amount) {
        if (amount > currentBalance || amount <= 0)
            return false;
        currentBalance -= amount;
        return true;
    }

    /**
     * Transfers an amount from the user's account to another user's account
     * @param amount the amount to be transferred
     * @param user the user to transfer to
     * @return whether successful or not
     */
    public boolean transfer(double amount, User user) {
        if (amount > currentBalance || amount <= 0)
            return false;
        user.getEwallet().deposit(amount);
        currentBalance -= amount;
        return true;
    }

    /**
     * Gets the balance of the user's account
     * @return the current balance
     */
    public double getBalance() {
        return currentBalance;
    }

}
