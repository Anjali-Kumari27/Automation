package miniproject2;

import java.io.*;
import java.util.*;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private final String FILE_NAME = "employees.dat";

    public EmployeeManager() {
        loadFromFile();
    }

    // Add Employee
    public void addEmployee(Employee emp) {
        for (Employee e : employees) {
            if (e.getId() == emp.getId()) {
                throw new RuntimeException("Employee ID must be unique!");
            }
        }
        if (emp.getSalary() <= 0)
            throw new RuntimeException("Salary must be positive!");

        employees.add(emp);
        saveToFile();
        System.out.println("Employee added successfully.");
    }

    // Display All
    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // Search
    public void searchById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Update Salary
    public void updateSalary(int id, double salary) {
        if (salary <= 0)
            throw new RuntimeException("Salary must be positive!");

        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setSalary(salary);
                saveToFile();
                System.out.println("Salary updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Delete
    public void deleteEmployee(int id) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                saveToFile();
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Sorted Display
    public void displaySorted() {
        employees.sort(Comparator.comparingInt(Employee::getId));
        displayAll();
    }

    // Display Departments
    public void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : employees) {
            depts.add(e.getDepartment());
        }
        System.out.println("Departments: " + depts);
    }

    // File Handling
    private void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (Exception e) {
            System.out.println("File saving error.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (Exception e) {
            employees = new ArrayList<>();
        }
    }
}

