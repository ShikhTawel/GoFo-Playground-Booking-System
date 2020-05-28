package Classes;

import java.util.Scanner;

public class eWallet {
    private double currentBalance;

    public eWallet() {
        currentBalance = 0;
    }

    public boolean deposit(double amount)
    {
        if(amount<=0)
            return false;
        currentBalance+=amount;
        return true;
    }

    public boolean withdraw(double amount)
    {
        if(amount>currentBalance)
            return false;
        currentBalance-=amount;
        return true;
    }

    public boolean transfer(double amount, User user)
    {
        if(amount>currentBalance)
            return false;
        user.getEwallet().currentBalance+=amount;
        currentBalance-=amount;
        return true;
    }

    public double getBalance() {
        return currentBalance;
    }

}
