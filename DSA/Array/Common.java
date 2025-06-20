package DSA.Array;

import java.util.Arrays;

public class Common {
    public static int[][] getSampleInputMatrix() {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        return matrix;
    }

    public static int[] getSampleInputArray() {
        return new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    }

    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
