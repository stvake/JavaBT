package org.labs.lab1;

import java.util.Scanner;

/*
    C5 = 0: C = a * B, a - const
    C7 = 1: byte type
    C11 = 3: Обчислити суму найбільших елементів кожного рядка матриці.
*/
public class Lab1 {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int cols = scanner.nextInt();

            byte[][] B = new byte[rows][cols];

            System.out.println("Enter elements of matrix B (byte values):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    B[i][j] = scanner.nextByte();
                }
            }

            System.out.print("Enter the constant a (byte value): ");
            byte a = scanner.nextByte();

            MatrixCalculator calculator = new MatrixCalculator();

            byte[][] C = calculator.multiplyMatrixByConstant(a, B);

            System.out.println("Matrix C (a * B):");
            calculator.printMatrix(C);

            int sumOfExtremes = calculator.calculateSumOfExtremes(C);
            System.out.println("Sum of extremes in matrix C: " + sumOfExtremes);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
