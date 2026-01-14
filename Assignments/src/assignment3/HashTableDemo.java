package assignment3;

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Set;

public class HashTableDemo {
    public static void main(String[] args) {
        // 1. Constructors
        // Default constructor
        Hashtable<Integer, String> table1 = new Hashtable<>();

        // Constructor with initial capacity
        Hashtable<Integer, String> table2 = new Hashtable<>(5);

        // Constructor with initial capacity and load factor
        Hashtable<Integer, String> table3 = new Hashtable<>(5, 0.75f);

        // Constructor with another map
        Hashtable<Integer, String> tempMap = new Hashtable<>();
        tempMap.put(1, "One");
        tempMap.put(2, "Two");
        Hashtable<Integer, String> table4 = new Hashtable<>(tempMap);

        System.out.println("=== Constructors Demo ===");
        System.out.println("table1: " + table1);
        System.out.println("table2: " + table2);
        System.out.println("table3: " + table3);
        System.out.println("table4: " + table4);

        // 2. Methods demo
        Hashtable<Integer, String> table = new Hashtable<>();

        // put(K, V)
        table.put(101, "Alice");
        table.put(102, "Bob");
        table.put(103, "Charlie");

        // putIfAbsent(K, V)
        table.putIfAbsent(102, "David"); // won't replace Bob

        // get(K)
        System.out.println("\nGet value for key 101: " + table.get(101));

        // remove(K)
        table.remove(103);

        // containsKey(K)
        System.out.println("Contains key 102? " + table.containsKey(102));

        // containsValue(V)
        System.out.println("Contains value 'Charlie'? " + table.containsValue("Charlie"));

        // size()
        System.out.println("Size of table: " + table.size());

        // isEmpty()
        System.out.println("Is table empty? " + table.isEmpty());

        // keySet()
        Set<Integer> keys = table.keySet();
        System.out.println("Keys: " + keys);

        // values()
        System.out.println("Values: " + table.values());

        // clear()
        // table.clear(); // Uncomment to clear table

        // putAll(Map)
        Hashtable<Integer, String> newTable = new Hashtable<>();
        newTable.put(201, "Eve");
        newTable.put(202, "Frank");
        table.putAll(newTable);

        // clone()
        Hashtable<Integer, String> cloneTable = (Hashtable<Integer, String>) table.clone();
        System.out.println("Cloned table: " + cloneTable);

        // equals(Object)
        System.out.println("table equals cloneTable? " + table.equals(cloneTable));

        // elements() - returns Enumeration of values
        System.out.println("Enumeration of values:");
        Enumeration<String> e = table.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        // entrySet()
        System.out.println("Entry Set: " + table.entrySet());

        // toString()
        System.out.println("Table as string: " + table.toString());

        System.out.println("\nFinal Hashtable: " + table);
    }
}

