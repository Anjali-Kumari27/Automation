package miniproject3;

import java.io.*;
import java.util.*;

class Student {
    int eno;
    String name;
    String  branch;
    int sem;
    double percentage;

    Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public String toString() {
        return eno + "," + name + "," + branch + "," + sem + "," + percentage;
    }
}

public class StudentApp {

    static ArrayList<Student> list = new ArrayList<>();
    static final String FILE = "students.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LOGIN
        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("Login → Username: admin | Password: admin");

        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        if (!u.equals("admin") || !p.equals("admin")) {
            System.out.println("Invalid Login!");
            return;
        }

        loadFromFile();

        int choice;
        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update Branch 5.Delete 6.Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: add(sc); break;
                case 2: display(); break;
                case 3: search(sc); break;
                case 4: update(sc); break;
                case 5: delete(sc); break;
                case 6: System.out.println("System Closed."); break;
            }
        } while (choice != 6);
    }

    static void add(Scanner sc) {
        try {
            System.out.print("Eno: ");
            int eno = Integer.parseInt(sc.nextLine());

            for (Student s : list)
                if (s.eno == eno) {
                    System.out.println("Eno must be unique!");
                    return;
                }

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Branch: ");
            String branch = sc.nextLine();
            if (branch.isEmpty()) {
                System.out.println("Branch cannot be empty!");
                return;
            }

            System.out.print("Sem: ");
            int sem = Integer.parseInt(sc.nextLine());

            System.out.print("Percentage: ");
            double per = Double.parseDouble(sc.nextLine());
            if (per <= 0) {
                System.out.println("Percentage must be positive!");
                return;
            }

            list.add(new Student(eno, name, branch, sem, per));
            saveToFile();
            System.out.println("Student added!");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    static void display() {
        if (list.isEmpty()) {
            System.out.println("No records.");
            return;
        }
        for (Student s : list)
            System.out.println(s);
    }

    static void search(Scanner sc) {
        System.out.print("Eno: ");
        int eno = Integer.parseInt(sc.nextLine());

        for (Student s : list)
            if (s.eno == eno) {
                System.out.println(s);
                return;
            }
        System.out.println("Student not found!");
    }

    static void update(Scanner sc) {
        System.out.print("Eno: ");
        int eno = Integer.parseInt(sc.nextLine());

        for (Student s : list) {
            if (s.eno == eno) {
                System.out.print("New Branch: ");
                String b = sc.nextLine();
                if (b.isEmpty()) {
                    System.out.println("Branch cannot be empty!");
                    return;
                }
                s.branch = b;
                saveToFile();
                System.out.println("Branch updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void delete(Scanner sc) {
        System.out.print("Eno: ");
        int eno = Integer.parseInt(sc.nextLine());

        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().eno == eno) {
                it.remove();
                saveToFile();
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE));
            for (Student s : list)
                pw.println(s);
            pw.close();
        } catch (Exception e) {
            System.out.println("File error!");
        }
    }

    static void loadFromFile() {
        try {
            File f = new File(FILE);
            if (!f.exists()) return;

            Scanner fs = new Scanner(f);
            while (fs.hasNextLine()) {
                String[] d = fs.nextLine().split(",");
                list.add(new Student(
                        Integer.parseInt(d[0]),
                        d[1], d[2],
                        Integer.parseInt(d[3]),
                        Double.parseDouble(d[4])
                ));
            }
            fs.close();
        } catch (Exception e) {
            System.out.println("File read error!");
        }
    }
}
