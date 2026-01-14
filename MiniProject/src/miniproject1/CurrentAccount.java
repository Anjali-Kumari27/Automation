package miniproject1;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Method overriding
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited in Current Account");
    }

    @Override
    public boolean withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawal successful from Current Account");
        return true;
    }
}

