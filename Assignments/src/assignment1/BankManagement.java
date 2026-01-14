package assignment1;

/*
 * Design a console-based Bank Management Program in Java that allows a user to create a 
bank account and perform basic banking operations such as deposit, withdrawal, balance 
enquiry, and account details display. The program should handle exceptions as required
 */

import java.util.Scanner;

//This class is like a blueprint for a Bank Account
class BankAccount {
 String accountHolder;
 String accountNo;
 double balance;

 // Constructor to set up the account
 public BankAccount(String name, String accNo) {
     this.accountHolder = name;
     this.accountNo = accNo;
     this.balance = 0.0; // Start with zero money
 }

 // Method to add money
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited: " + amount);
     } else {
         System.out.println("You can't deposit a negative amount!");
     }
 }

 // Method to take money out (with Exception Handling)
 public void withdraw(double amount) throws Exception {
     if (amount > balance) {
         // Throwing an error if money is not enough
         throw new Exception("Insufficient Balance! You only have: " + balance);
     } else if (amount <= 0) {
         throw new Exception("Please enter a valid amount to withdraw.");
     } else {
         balance -= amount;
         System.out.println("Successfully withdrawn: " + amount);
     }
 }

 // Method to show details
 public void displayDetails() {
     System.out.println("\n--- Account Details ---");
     System.out.println("Holder: " + accountHolder);
     System.out.println("Account Number: " + accountNo);
     System.out.println("Current Balance: " + balance);
 }
}

public class BankManagement {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // 1. Create the account
     System.out.println("Welcome to the Student Bank!");
     System.out.print("Enter your name: ");
     String name = sc.nextLine();
     System.out.print("Enter an Account Number: ");
     String accNo = sc.next();

     BankAccount myAcc = new BankAccount(name, accNo);

     int choice;
     do {
         System.out.println("\n1. Deposit  2. Withdraw  3. Balance Enquiry  4. Details  0. Exit");
         System.out.print("Choose an option: ");
         choice = sc.nextInt();

         try {
             switch (choice) {
                 case 1:
                     System.out.print("Enter amount to deposit: ");
                     myAcc.deposit(sc.nextDouble());
                     break;
                 case 2:
                     System.out.print("Enter amount to withdraw: ");
                     myAcc.withdraw(sc.nextDouble());
                     break;
                 case 3:
                     System.out.println("Your balance is: " + myAcc.balance);
                     break;
                 case 4:
                     myAcc.displayDetails();
                     break;
             }
         } catch (Exception e) {
             // This catches the error and prints the message we wrote above
             System.out.println("Error: " + e.getMessage());
         }

     } while (choice != 0);

     System.out.println("Thank you for using our bank!");
 }
}