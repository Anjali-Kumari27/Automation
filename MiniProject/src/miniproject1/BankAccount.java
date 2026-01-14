package miniproject1;

import java.io.Serializable;

// Abstract class (Abstraction)
public abstract class BankAccount implements Serializable {

    // Encapsulation using private
    private int accountNumber;
    private String holderName;
    protected double balance;

    // Constructor
    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters (Encapsulation)
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    // Concrete method
    public double getBalance() {
        return balance;
    }

    // Abstract methods
    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
