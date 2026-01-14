package assignment2.unversitysystem;

/*
 * Design a console-based University Student Management System using Java Collection 
Framework that manages students, courses, and marks using ArrayList, Vector, Stack, list, 
set & map, Hashmap, Hashtable, TreeMap.
Add student records, Display all students, Remove student by ID, Search student by ID, Sort 
students by marks, Convert HashMap to TreeMap, Count students course-wise, Store unique 
course names, Prevent duplicate entries and Display all courses. The program should handle 
exceptions, use interface and REGEX as required.
 */

import java.util.Scanner;

public class UniversitySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityManager manager = new UniversityManager();
        int choice;

        do {
            System.out.println("\n--- UNIVERSITY SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Show Sorted Marks Map");
            System.out.println("7. Course Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        System.out.print("Marks: ");
                        int marks = Integer.parseInt(sc.nextLine());

                        manager.addStudent(id, name, course, marks);
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.removeStudent(Integer.parseInt(sc.nextLine()));
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        manager.searchStudent(Integer.parseInt(sc.nextLine()));
                        break;

                    case 5:
                        manager.sortAndDisplay();
                        break;

                    case 6:
                        manager.convertAndShowMap();
                        break;

                    case 7:
                        manager.showUniqueCourses();
                        break;

                    case 0:
                        System.out.println("System closed.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}

