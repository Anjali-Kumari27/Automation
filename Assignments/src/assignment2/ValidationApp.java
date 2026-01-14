package assignment2;

/*
 * Write a simple Java Program which demonstrate the use of REGEX in Java and provides 
Input Validation Using Regular Expressions. The program should have following menu
1. Validate Mobile Number
2. Validate Email ID
3. Validate Username
4. Validate Password
5. Exit.
After validation a simple welcome message displayed and if validation failed then invalid 
input message should displayed. The program should handle exceptions as required.
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Simple menu for the student project
            System.out.println("\n--- Input Validator Menu ---");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            // Try-catch to handle if user types letters instead of numbers for menu
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 5!");
                choice = 0;
                continue;
            }

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter the text to validate: ");
                String input = sc.nextLine();
                boolean isValid = false;

                // Checking based on user choice
                switch (choice) {
                    case 1:
                        // Checks for exactly 10 digits
                        isValid = checkRegex("^[0-9]{10}$", input);
                        break;
                    case 2:
                        // Checks for basic email format like name@mail.com
                        isValid = checkRegex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", input);
                        break;
                    case 3:
                        // Username: 5-12 letters/numbers only
                        isValid = checkRegex("^[a-zA-Z0-9]{5,12}$", input);
                        break;
                    case 4:
                        // Password: Needs at least 1 digit and 8 characters total
                        isValid = checkRegex("^(?=.*[0-9]).{8,}$", input);
                        break;
                }

                // Show welcome message if correct, otherwise show error
                if (isValid) {
                    System.out.println("Success! Welcome, the input is valid.");
                } else {
                    System.out.println("Invalid input! Please follow the rules.");
                }
            }

        } while (choice != 5);

        System.out.println("Program closed. Goodbye!");
    }

    // A simple method to compare text with a secret code (Regex)
    public static boolean checkRegex(String patternCode, String userInput) {
        Pattern p = Pattern.compile(patternCode);
        Matcher m = p.matcher(userInput);
        return m.matches();
    }
}
