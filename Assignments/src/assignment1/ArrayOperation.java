package assignment1;

/*
 * Write a menu driven program in Java to perform insertion, deletion, linear search, binary 
search, to find maximum value, to count even/ odd and to perform insertion sort operation in 
one dimensional array.
 */

import java.util.Scanner;

public class ArrayOperation {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        // Ask the user how many numbers they want to store
	        System.out.print("How many total numbers can your list hold? ");
	        int totalSpace = sc.nextInt();
	        
	        // We create the array based on that user input
	        int[] arr = new int[totalSpace];
	        int size = 0; // This is how many numbers we have actually typed in so far
	        int choice;

	        do {
	            System.out.println("\n--- MENU ---");
	            System.out.println("1. Insert Number");
	            System.out.println("2. Delete Number (by position)");
	            System.out.println("3. Linear Search");
	            System.out.println("4. Binary Search (Sort first!)");
	            System.out.println("5. Find Max");
	            System.out.println("6. Count Even/Odd");
	            System.out.println("7. Sort (Insertion Sort)");
	            System.out.println("8. Show All");
	            System.out.println("0. Exit");
	            System.out.print("What do you want to do? ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    // Check if there is still room in the array
	                    if (size < totalSpace) {
	                        System.out.print("Enter number: ");
	                        arr[size] = sc.nextInt();
	                        size++;
	                        System.out.println("Done!");
	                    } else {
	                        System.out.println("No more room in the array!");
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter index to delete: ");
	                    int index = sc.nextInt();
	                    if (index >= 0 && index < size) {
	                        // Shift everyone to the left to close the gap
	                        for (int i = index; i < size - 1; i++) {
	                            arr[i] = arr[i + 1];
	                        }
	                        size--;
	                        System.out.println("Removed!");
	                    } else {
	                        System.out.println("That spot doesn't exist!");
	                    }
	                    break;

	                case 3:
	                    System.out.print("Search for: ");
	                    int key = sc.nextInt();
	                    int foundAt = -1;
	                    for (int i = 0; i < size; i++) {
	                        if (arr[i] == key) {
	                            foundAt = i;
	                            break;
	                        }
	                    }
	                    System.out.println(foundAt != -1 ? "Found at index " + foundAt : "Not here!");
	                    break;

	                case 4:
	                    // Binary search logic
	                    System.out.print("Search for: ");
	                    int sKey = sc.nextInt();
	                    int low = 0, high = size - 1, res = -1;
	                    while (low <= high) {
	                        int mid = (low + high) / 2;
	                        if (arr[mid] == sKey) { res = mid; break; }
	                        if (arr[mid] < sKey) low = mid + 1;
	                        else high = mid - 1;
	                    }
	                    System.out.println(res != -1 ? "Found at " + res : "Not found (Did you sort?)");
	                    break;

	                case 5:
	                    if (size == 0) System.out.println("Empty!");
	                    else {
	                        int max = arr[0];
	                        for (int i = 1; i < size; i++) {
	                            if (arr[i] > max) max = arr[i];
	                        }
	                        System.out.println("Max is: " + max);
	                    }
	                    break;

	                case 6:
	                    int e = 0, o = 0;
	                    for (int i = 0; i < size; i++) {
	                        if (arr[i] % 2 == 0) e++; else o++;
	                    }
	                    System.out.println("Evens: " + e + " | Odds: " + o);
	                    break;

	                case 7:
	                    // Sorting like a deck of cards
	                    for (int i = 1; i < size; i++) {
	                        int current = arr[i];
	                        int j = i - 1;
	                        while (j >= 0 && arr[j] > current) {
	                            arr[j + 1] = arr[j];
	                            j--;
	                        }
	                        arr[j + 1] = current;
	                    }
	                    System.out.println("Sorted the list!");
	                    break;

	                case 8:
	                    System.out.print("Your List: ");
	                    for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
	                    System.out.println();
	                    break;
	            }
	        } while (choice != 0);
	        
	        System.out.println("Goodbye!");
	    }
}
