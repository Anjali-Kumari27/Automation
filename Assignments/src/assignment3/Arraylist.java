package assignment3;

import java.util.*;

public class Arraylist {

    public static void main(String[] args) {

        // ===== CONSTRUCTOR 1: Default =====
        ArrayList<String> list1 = new ArrayList<>();

        // add()
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        // add(index, element)
        list1.add(1, "HTML");

        // get()
        System.out.println("Element at index 2: " + list1.get(2));

        // set()
        list1.set(2, "CSS");

        // contains()
        System.out.println("Contains Java? " + list1.contains("Java"));

        // indexOf()
        System.out.println("Index of Java: " + list1.indexOf("Java"));

        // size()
        System.out.println("Size: " + list1.size());

        // isEmpty()
        System.out.println("Is Empty? " + list1.isEmpty());

        // ===== CONSTRUCTOR 2: With Initial Capacity =====
        ArrayList<String> list2 = new ArrayList<>(5);
        list2.add("Spring");
        list2.add("Hibernate");

        // addAll()
        list2.addAll(list1);

        // ===== CONSTRUCTOR 3: Using Collection =====
        ArrayList<String> list3 = new ArrayList<>(list2);

        // remove(index)
        list3.remove(0);

        // remove(object)
        list3.remove("Java");

        // ensureCapacity()
        list3.ensureCapacity(20);

        // iterator()
        System.out.println("\nIterating list3:");
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // toArray()
        Object[] arr = list3.toArray();
        System.out.println("\nArray Elements:");
        for (Object o : arr) {
            System.out.println(o);
        }

        // clear()
        list3.clear();
        System.out.println("\nAfter clear(), size: " + list3.size());
    }
}

