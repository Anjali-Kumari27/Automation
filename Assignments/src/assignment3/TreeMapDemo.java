package assignment3;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        // ========================
        // 1. Constructors
        // ========================
        
        // Default constructor
        TreeMap<Integer, String> tree1 = new TreeMap<>();

        // Constructor with a comparator (reverse order)
        TreeMap<Integer, String> tree2 = new TreeMap<>(Collections.reverseOrder());

        // Constructor with another map
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(1, "One");
        tempMap.put(2, "Two");
        TreeMap<Integer, String> tree3 = new TreeMap<>(tempMap);

        System.out.println("\n==================================");
        System.out.println("          Constructors Demo        ");
        System.out.println("==================================\n");
        System.out.println("tree1: " + tree1);
        System.out.println("tree2: " + tree2);
        System.out.println("tree3: " + tree3);

        // ========================
        // 2. Methods demo
        // ========================

        TreeMap<Integer, String> tree = new TreeMap<>();

        // put(K, V)
        tree.put(101, "Anjali");
        tree.put(103, "Chhavi");
        tree.put(102, "Bobby");

        // putIfAbsent(K, V)
        tree.putIfAbsent(102, "David"); // won't replace Bob

        // get(K)
        System.out.println("\nGet value for key 101: " + tree.get(101));

        // remove(K)
        tree.remove(103);

        // containsKey(K)
        System.out.println("\nContains key 102 ?  " + tree.containsKey(102));

        // containsValue(V)
        System.out.println("\nContains value 'Chhavi' ?  " + tree.containsValue("Charlie"));

        // size()
        System.out.println("\nSize of tree: " + tree.size());

        // isEmpty()
        System.out.println("\nIs tree empty? " + tree.isEmpty());

        // keySet()
        System.out.println("\nKeys: " + tree.keySet());

        // values()
        System.out.println("\nValues: " + tree.values());

        // firstKey() and lastKey()
        System.out.println("First key: " + tree.firstKey());
        System.out.println("Last key: " + tree.lastKey());

        // higherKey(K) - next higher key
        System.out.println("\nHigher key than 101: " + tree.higherKey(101));

        // lowerKey(K) - next lower key
        System.out.println("Lower key than 102: " + tree.lowerKey(102));

        // ceilingKey(K) - >= key
        System.out.println("\nCeiling key for 101: " + tree.ceilingKey(101));

        // floorKey(K) - <= key
        System.out.println("Floor key for 102: " + tree.floorKey(102));

        // entrySet()
        System.out.println("\nEntry Set: " + tree.entrySet());

        // clear()
        // tree.clear(); // Uncomment to clear the tree

        // clone() - TreeMap does not have clone directly
        TreeMap<Integer, String> cloneTree = new TreeMap<>(tree);
        System.out.println("Cloned tree: " + cloneTree);

        // equals(Object)
        System.out.println("tree equals cloneTree ? " + tree.equals(cloneTree));

        // toString()
        System.out.println("\nTree as string: " + tree.toString());

        System.out.println("\n------------------------------------------------------");
        System.out.println("Final TreeMap: " + tree);
        System.out.println("------------------------------------------------------\n");
    }
}

