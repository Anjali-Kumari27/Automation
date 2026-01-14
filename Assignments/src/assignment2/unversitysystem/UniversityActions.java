package assignment2.unversitysystem;

public interface UniversityActions {
    void addStudent(int id, String name, String course, int marks);
    void displayAll();
    void removeStudent(int id);
    void searchStudent(int id);
    void sortAndDisplay();
    void convertAndShowMap();
    void showUniqueCourses();
}

