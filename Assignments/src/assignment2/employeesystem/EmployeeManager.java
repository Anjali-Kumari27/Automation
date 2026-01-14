package assignment2.employeesystem;

import java.util.*;
import java.util.regex.Pattern;

// The Logic Class
public class EmployeeManager implements EmployeeOperations {

    // HashMap: allows one null key
    private Map<Integer, String> hMap = new HashMap<>();

    // TreeMap: sorts by key
    private Map<Integer, String> tMap = new TreeMap<>();

    // Hashtable: no nulls allowed
    private Map<Integer, String> hTable = new Hashtable<>();

    // Regex to validate name
    private boolean isValidName(String name) {
        return Pattern.matches("^[a-zA-Z\\s]+$", name);
    }

    @Override
    public void addEmployee(int id, String name) {
        if (!isValidName(name)) {
            System.out.println("Error: Name should only contain letters!");
            return;
        }

        hMap.put(id, name);
        tMap.put(id, name);
        hTable.put(id, name);

        System.out.println("Employee added in all Maps!");
    }

    @Override
    public void displayAll() {
        System.out.println("\n--- Records in TreeMap (Sorted) ---");
        for (Map.Entry<Integer, String> entry : tMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                               " | Name: " + entry.getValue());
        }
    }

    @Override
    public void searchEmployee(int id) {
        if (hMap.containsKey(id)) {
            System.out.println("Found! Name: " + hMap.get(id));
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    @Override
    public void removeEmployee(int id) {
        if (hMap.containsKey(id)) {
            hMap.remove(id);
            tMap.remove(id);
            hTable.remove(id);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("ID not found.");
        }
    }

    // Demonstrates null support in Maps
    @Override
    public void checkNullSupport() {
        System.out.println("\n--- Testing Null Support ---");

        // HashMap
        try {
            hMap.put(null, "Ghost User");
            System.out.println("HashMap: Allowed null key.");
        } catch (Exception e) {
            System.out.println("HashMap: Failed.");
        }

        // Hashtable
        try {
            hTable.put(null, "Ghost User");
        } catch (Exception e) {
            System.out.println("Hashtable: Does NOT allow null keys.");
        }

        // TreeMap
        try {
            tMap.put(null, "Ghost User");
        } catch (Exception e) {
            System.out.println("TreeMap: Cannot sort null key.");
        }
    }
}
