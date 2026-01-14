package assignment2.employeesystem;

/*
 * Design a Java program to manage Employee Records using Hashmap, Hashtable, and 
TreeMap. The program should Add employee records, Display all employees, Search 
employee by employee ID, Remove employee by employee ID, Demonstrate null key and 
null value support. The program should handle exceptions, use interface and REGEX as 
required.
 */

import java.util.Scanner;

// The Main App
public class EmployeeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice = -1;

        System.out.println("Simple Employee Management System");

        while (choice != 0) {
            System.out.println("\n1. Add  2. Display  3. Search  4. Remove  5. Test Nulls  0. Exit");
            System.out.print("Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        manager.addEmployee(id, name);
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        manager.searchEmployee(Integer.parseInt(sc.nextLine()));
                        break;

                    case 4:
                        System.out.print("Enter ID to remove: ");
                        manager.removeEmployee(Integer.parseInt(sc.nextLine()));
                        break;

                    case 5:
                        manager.checkNullSupport();
                        break;

                    case 0:
                        System.out.println("Bye!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: Please enter valid input!");
                choice = -1;
            }
        }

        sc.close();
    }
}

