package org.labs.lab1;

// Клас для проведення операцій з матрицею
public class MatrixCalculator {

    // Метод для множення матриці на константу
    public byte[][] multiplyMatrixByConstant(byte a, byte[][] B) throws ArithmeticException {
        int rows = B.length;
        int cols = B[0].length;
        byte[][] C = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int result = a * B[i][j];
                if (result < Byte.MIN_VALUE || result > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Byte type overflow occurred when multiplying " +
                            a + " and " + B[i][j]);
                }
                C[i][j] = (byte) result;
            }
        }
        return C;
    }

    // Метод для обчислення суми найбільших елементів у кожному рядку
    public int calculateSumOfExtremes(byte[][] matrix){
        int sum = 0;

        for (byte[] row : matrix) {
            byte max = row[0];
            for (byte value : row) {
                if (value > max) {
                    max = value;
                }
            }
            sum += max;
        }
        return sum;
    }

    // Метод для виведення матриці
    public void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

