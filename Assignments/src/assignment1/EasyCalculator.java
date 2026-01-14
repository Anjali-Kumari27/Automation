package assignment1;

/*
 * A class sixth student required to solve basic mathematics problems. For this he/ she needs to 
perform operations such as addition, subtraction, multiplication, division, remainder, square, 
cube, and absolute. Write a program using methods to perform these basic operations.
 */

import java.util.Scanner;

public class EasyCalculator {

    public static void main(String[] args) {
        // These are our test numbers
        double num1 = 10;
        double num2 = 5;
        double num3 = -7;

        System.out.println("--- Simple Math Results ---");

        // We call our "machines" (methods) here to get the answers
        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
        System.out.println("Remainder: " + findRemainder(num1, num2));
        System.out.println("Square of 10: " + findSquare(num1));
        System.out.println("Cube of 5: " + findCube(num2));
        System.out.println("Absolute value of -7: " + findAbsolute(num3));
    }

    // 1. Method to add two numbers
    public static double add(double a, double b) {
        return a + b;
    }

    // 2. Method to subtract numbers
    public static double subtract(double a, double b) {
        return a - b;
    }

    // 3. Method to multiply numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // 4. Method to divide numbers
    public static double divide(double a, double b) {
        return a / b;
    }

    // 5. Method to find the leftover (remainder)
    public static double findRemainder(double a, double b) {
        return a % b;
    }

    // 6. Method to find square (number times itself)
    public static double findSquare(double a) {
        return a * a;
    }

    // 7. Method to find cube (number times itself three times)
    public static double findCube(double a) {
        return a * a * a;
    }

    // 8. Method to find absolute value (makes the number positive)
    public static double findAbsolute(double a) {
        if (a < 0) {
            return -a; // If it's negative, flip it to positive
        } else {
            return a;  // If it's already positive, keep it
        }
    }
}