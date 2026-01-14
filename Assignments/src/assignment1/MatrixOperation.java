package assignment1;
/*
 * Write a program to perform addition, subtraction, multiplication, transpose, to check square 
matrix, to check matrix is diagonal, and to check matrix is identity.
 */
import java.util.Scanner;

public class MatrixOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Set up the first matrix
        System.out.print("Enter rows for Matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns for Matrix A: ");
        int c1 = sc.nextInt();
        int[][] A = new int[r1][c1];

        System.out.println("Enter numbers for Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Step 2: Check properties of Matrix A
        System.out.println("\n--- Checking Matrix A ---");
        
        // A square matrix has same rows and columns (like a perfect square!)
        boolean isSquare = (r1 == c1);
        System.out.println("Is Square? " + isSquare);

        if (isSquare) {
            checkSpecialTypes(A, r1);
        } else {
            System.out.println("Not square, so it can't be Diagonal or Identity.");
        }

        // Step 3: Transpose (flipping the matrix over its diagonal)
        System.out.println("\n--- Transpose of A ---");
        for (int i = 0; i < c1; i++) {
            for (int j = 0; j < r1; j++) {
                System.out.print(A[j][i] + " "); // We print column as row
            }
            System.out.println();
        }

        // Step 4: Simple Math (requires another matrix)
        System.out.println("\nTo add/subtract, we need Matrix B of the same size (" + r1 + "x" + c1 + ")");
        int[][] B = new int[r1][c1];
        System.out.println("Enter numbers for Matrix B:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nAddition Result:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print((A[i][j] + B[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // This helper checks if the matrix is Diagonal or Identity
    public static void checkSpecialTypes(int[][] mat, int n) {
        boolean isDiagonal = true;
        boolean isIdentity = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Diagonal: all numbers NOT on the main diagonal must be 0
                if (i != j && mat[i][j] != 0) {
                    isDiagonal = false;
                }
                // Identity: must be diagonal AND the main diagonal must be all 1s
                if (i == j && mat[i][j] != 1) {
                    isIdentity = false;
                }
            }
        }
        
        System.out.println("Is Diagonal? " + isDiagonal);
        System.out.println("Is Identity? " + (isDiagonal && isIdentity));
    }
}