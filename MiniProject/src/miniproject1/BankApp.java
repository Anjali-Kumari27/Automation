package miniproject1;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        BankAccount account = null;

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("           BANK MANAGEMENT SYSTEM         ");
            System.out.println("========================================\n");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.println("\n1. Savings  2. Current");
                        int type = sc.nextInt();

                        System.out.print("Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        // Runtime Polymorphism
                        if (type == 1)
                            account = new SavingsAccount(accNo, name, bal);
                        else
                            account = new CurrentAccount(accNo, name, bal);

                        service.saveAccount(account);
                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        account = service.loadAccount();
                        System.out.print("\nEnter amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        service.saveAccount(account);
                        break;

                    case 3:
                        account = service.loadAccount();
                        System.out.print("\nEnter amount: ");
                        double w = sc.nextDouble();
                        account.withdraw(w);
                        service.saveAccount(account);
                        break;

                    case 4:
                        account = service.loadAccount();
                        System.out.println("\nBalance: " + account.getBalance());
                        break;

                    case 5:
                        account = service.loadAccount();
                        account.displayDetails();
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: No account found!");
            }

        } while (choice != 0);

        sc.close();
    }
}

