package assignment2;

/*
 * Design a Java program where a bank account class implements multiple interfaces to perform 
banking and customer-related operations. The program should handle exceptions as required
 */

import java.util.Scanner;

//Rulebook for banking tasks
interface BankingActions {
 void deposit(double amount);
 void withdraw(double amount) throws Exception;
 void showBalance();
}

//Rulebook for customer tasks
interface CustomerActions {
 void updateAddress(String newAddress);
 void showCustomerProfile();
}

//This class does all the work and follows the rules above
class MySmartAccount implements BankingActions, CustomerActions {
 String name;
 String address;
 double balance;

 // Setting up the account with name and address
 public MySmartAccount(String name, String address) {
     this.name = name;
     this.address = address;
     this.balance = 0.0;
 }

 // Adding money to the balance
 public void deposit(double amount) {
     if (amount > 0) {
         balance = balance + amount;
         System.out.println("Money added!");
     }
 }

 // Taking money out (gives error if balance is too low)
 public void withdraw(double amount) throws Exception {
     if (amount > balance) {
         // This message will show if the student is out of money
         throw new Exception("Sorry, not enough balance!");
     }
     balance = balance - amount;
     System.out.println("Money taken out!");
 }

 // Just printing the balance
 public void showBalance() {
     System.out.println("Your current balance: " + balance);
 }

 // Changing the home address
 public void updateAddress(String newAddress) {
     this.address = newAddress;
     System.out.println("Address changed!");
 }

 // Showing everything about the user
 public void showCustomerProfile() {
     System.out.println("\n--- My Bank Profile ---");
     System.out.println("Name: " + name);
     System.out.println("Address: " + address);
     System.out.println("Balance: " + balance);
 }
}

//This is the main part that runs the program
public class MainBank {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Getting user details
     System.out.println("Welcome to my Bank Project");
     System.out.print("Enter your Name: ");
     String n = sc.nextLine();
     System.out.print("Enter your Address: ");
     String addr = sc.nextLine();

     // Making the account object
     MySmartAccount userAcc = new MySmartAccount(n, addr);

     int choice;
     do {
         // Making a simple menu
         System.out.println("\n1. Deposit 2. Withdraw 3. Check Balance 4. Profile 0. Exit");
         System.out.print("What do you want to do? ");
         choice = sc.nextInt();

         // try-catch helps handle the "not enough money" error safely
         try {
             if (choice == 1) {
                 System.out.print("Enter amount: ");
                 userAcc.deposit(sc.nextDouble());
             } else if (choice == 2) {
                 System.out.print("Enter amount: ");
                 userAcc.withdraw(sc.nextDouble());
             } else if (choice == 3) {
                 userAcc.showBalance();
             } else if (choice == 4) {
                 userAcc.showCustomerProfile();
             }
         } catch (Exception e) {
             // If there is an error, print it here
             System.out.println("Wait! " + e.getMessage());
         }

     } while (choice != 0); // Keep going until user types 0

     System.out.println("Project finished. Bye!");
 }
}