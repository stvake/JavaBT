package org.labs.lab1;

public class MatrixCalculator {

    public byte[][] multiplyMatrixByConstant(byte a, byte[][] B) {
        int rows = B.length;
        int cols = B[0].length;
        byte[][] C = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = (byte) (a * B[i][j]);
            }
        }
        return C;
    }

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

    public void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

