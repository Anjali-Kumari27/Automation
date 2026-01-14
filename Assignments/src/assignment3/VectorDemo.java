package assignment3;

import java.util.*;

public class VectorDemo {

    public static void main(String[] args) {

        // ===== CONSTRUCTOR 1: Default =====
        Vector<String> v1 = new Vector<>();

        // add()
        v1.add("Java");
        v1.add("Python");

        // addElement()
        v1.addElement("C++");

        // add(index, element)
        v1.add(1, "HTML");

        // get()
        System.out.println("get(2): " + v1.get(2));

        // elementAt()
        System.out.println("elementAt(0): " + v1.elementAt(0));

        // set()
        v1.set(2, "CSS");

        // contains()
        System.out.println("Contains Java? " + v1.contains("Java"));

        // indexOf()
        System.out.println("Index of Java: " + v1.indexOf("Java"));

        // size()
        System.out.println("Size: " + v1.size());

        // isEmpty()
        System.out.println("Is Empty? " + v1.isEmpty());

        // ===== CONSTRUCTOR 2: Initial Capacity =====
        Vector<String> v2 = new Vector<>(5);

        // ===== CONSTRUCTOR 3: Capacity Increment =====
        Vector<String> v3 = new Vector<>(3, 2);
        System.out.println("\nInitial Capacity of v3: " + v3.capacity());

        v3.add("Spring");
        v3.add("Hibernate");
        v3.add("JPA");
        v3.add("JDBC"); // capacity increases here

        System.out.println("Capacity after adding elements: " + v3.capacity());

        // ===== CONSTRUCTOR 4: Collection =====
        Vector<String> v4 = new Vector<>(v1);

        // remove(index)
        v4.remove(1);

        // removeElement()
        v4.removeElement("Java");

        // elements() - Enumeration
        System.out.println("\nUsing Enumeration:");
        Enumeration<String> e = v4.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        // clear()
        v4.clear();
        System.out.println("\nAfter clear(), size: " + v4.size());
    }
}

