package miniproject1;

//Hierarchical Inheritance
public class SavingsAccount extends BankAccount {

 public SavingsAccount(int accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // Method overriding
 @Override
 public void deposit(double amount) {
     balance += amount;
     System.out.println("Amount deposited in Savings Account");
 }

 @Override
 public boolean withdraw(double amount) {
     if (balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawal successful from Savings Account");
         return true;
     }
     System.out.println("Insufficient balance!");
     return false;
 }
}

