package miniproject2;


import java.util.Scanner;

public class EmployeeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginService login = new LoginService();
        EmployeeManager manager = new EmployeeManager();

        System.out.println("\n==============================================");
        System.out.println("           EMPLOYEE MANAGEMENT SYSTEM           ");
        System.out.println("==============================================\n");

        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        if (!login.login(u, p)) {
            System.out.println("Invalid Login!");
            return;
        }

        int choice;
        do {
            System.out.println("\n1.Add \n2.Display \n3.Search \n4.Update Salary");
            System.out.println("5.Delete \n6.Sorted \n7.Departments \n8.Exit");
            System.out.print("\nChoice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        if (dept.isEmpty())
                            throw new RuntimeException("Department cannot be empty!");
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();

                        manager.addEmployee(new Employee(id, name, dept, sal));
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        manager.searchById(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int uid = sc.nextInt();
                        System.out.print("New Salary: ");
                        manager.updateSalary(uid, sc.nextDouble());
                        break;

                    case 5:
                        System.out.print("ID: ");
                        manager.deleteEmployee(sc.nextInt());
                        break;

                    case 6:
                        manager.displaySorted();
                        break;

                    case 7:
                        manager.displayDepartments();
                        break;

                    case 8:
                        System.out.println("\n----------------------------------------------");
                        System.out.println("        Thankyou for using the system...        ");
                        System.out.println("----------------------------------------------\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }

        } while (choice != 8);

        sc.close();
    }
}
