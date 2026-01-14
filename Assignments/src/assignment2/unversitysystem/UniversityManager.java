package assignment2.unversitysystem;

import java.util.*;

public class UniversityManager implements UniversityActions {

    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Integer, Integer> marksMap = new HashMap<>();
    private HashSet<String> courses = new HashSet<>();

    @Override
    public void addStudent(int id, String name, String course, int marks) {

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        Student s = new Student(id, name, course, marks);
        students.add(s);
        marksMap.put(id, marks);
        courses.add(course);

        System.out.println("Student added successfully.");
    }

    @Override
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Override
    public void removeStudent(int id) {
        boolean removed = false;

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                removed = true;
                break;
            }
        }

        marksMap.remove(id);

        if (removed)
            System.out.println("Student removed.");
        else
            System.out.println("Student not found.");
    }

    @Override
    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    public void sortAndDisplay() {
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return b.marks - a.marks;
            }
        });

        System.out.println("Students sorted by marks:");
        displayAll();
    }

    @Override
    public void convertAndShowMap() {
        TreeMap<Integer, Integer> sorted = new TreeMap<>(marksMap);
        System.out.println("Sorted Marks (ID → Marks): " + sorted);
    }

    @Override
    public void showUniqueCourses() {
        System.out.println("Courses offered:");
        for (String c : courses) {
            int count = 0;
            for (Student s : students) {
                if (s.course.equalsIgnoreCase(c)) {
                    count++;
                }
            }
            System.out.println(c + " : " + count + " student(s)");
        }
    }
}
