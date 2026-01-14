package assignment3;

import java.util.*;

public class Hashmap {

    public static void main(String[] args) {

        // ===== CONSTRUCTOR 1: Default =====
        HashMap<Integer, String> map1 = new HashMap<>();

        // put()
        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");

        // putIfAbsent()
        map1.putIfAbsent(2, "HTML"); // will NOT overwrite

        // get()
        System.out.println("Value of key 2: " + map1.get(2));

        // containsKey()
        System.out.println("Contains key 1? " + map1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Java? " + map1.containsValue("Java"));

        // size()
        System.out.println("Size: " + map1.size());

        // isEmpty()
        System.out.println("Is Empty? " + map1.isEmpty());

        // ===== CONSTRUCTOR 2: Initial Capacity =====
        HashMap<Integer, String> map2 = new HashMap<>(10);

        // ===== CONSTRUCTOR 3: Capacity + Load Factor =====
        HashMap<Integer, String> map3 = new HashMap<>(5, 0.75f);
        map3.put(10, "Spring");
        map3.put(20, "Hibernate");

        // ===== CONSTRUCTOR 4: Using Map =====
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        // remove(key)
        map4.remove(1);

        // remove(key, value)
        map4.remove(3, "C++");

        // replace()
        map4.replace(2, "Python", "React");

        // keySet()
        System.out.println("\nKeys: " + map4.keySet());

        // values()
        System.out.println("Values: " + map4.values());

        // entrySet()
        System.out.println("\nEntries:");
        for (Map.Entry<Integer, String> entry : map4.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // forEach()
        System.out.println("\nUsing forEach:");
        map4.forEach((k, v) -> System.out.println(k + " -> " + v));

        // clear()
        map4.clear();
        System.out.println("\nAfter clear(), size: " + map4.size());
    }
}
