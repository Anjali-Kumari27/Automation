package assignment2.employeesystem;

//Rules for our system
public interface EmployeeOperations {
 void addEmployee(int id, String name);
 void displayAll();
 void searchEmployee(int id);
 void removeEmployee(int id);
 void checkNullSupport();
}
