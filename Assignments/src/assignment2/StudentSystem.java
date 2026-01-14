package assignment2;

/*
 * Design a Java program to manage Student Records using different ArrayList, Vector, List 
collections. The program should Add student records, Display all students, Remove a student 
by roll number, Search a student by roll number. The program should handle exceptions, use 
interface and REGEX as required.
 */

import java.util.*;
import java.util.regex.Pattern;

// Define the rules for our system
interface StudentOperations {
    void addStudent(String name, String roll);
    void displayAll();
    void removeStudent(String roll);
    void searchStudent(String roll);
}

// Create a simple Student class to hold data
class Student {
    String name;
    String rollNo;

    Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // A simple way to print student info
    public String toString() {
        return "Roll No: " + rollNo + " | Name: " + name;
    }
}

// Implement the system
class StudentManager implements StudentOperations {
    // We use a List (ArrayList) to store our Student objects
    List<Student> list = new ArrayList<>();

    // Using Regex to make sure Roll Number is just digits (e.g., "101")
    private boolean isValidRoll(String roll) {
        return Pattern.matches("^[0-9]+$", roll);
    }

    public void addStudent(String name, String roll) {
        if (!isValidRoll(roll)) {
            System.out.println("Error: Roll number must be numbers only!");
            return;
        }
        list.add(new Student(name, roll));
        System.out.println("Student added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("\n--- All Student Records ---");
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }

    public void removeStudent(String roll) {
        boolean found = false;
        // Using an Iterator to safely remove items while looping
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().rollNo.equals(roll)) {
                it.remove();
                found = true;
                System.out.println("Student removed!");
                break;
            }
        }
        if (!found) System.out.println("Student not found!");
    }

    public void searchStudent(String roll) {
        for (Student s : list) {
            if (s.rollNo.equals(roll)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

// The Main Menu
public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice = -1;

        System.out.println("Welcome to Student Record Manager");

        while (choice != 0) {
            System.out.println("\n1. Add  2. Display  3. Remove  4. Search  0. Exit");
            System.out.print("Enter choice: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Roll No: ");
                        String roll = sc.nextLine();
                        manager.addStudent(name, roll);
                        break;
                    case 2:
                        manager.displayAll();
                        break;
                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        manager.removeStudent(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter Roll No to search: ");
                        manager.searchStudent(sc.nextLine());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong! Please try again.");
            }
        }
        System.out.println("\nProgram Closed!!!!!!");
    }
}
