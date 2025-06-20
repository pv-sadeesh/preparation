package DSA.Array;

public class RotateClockwise {
    public static void execute(int[][] matrix) {
        // STEP-1: Transpose the input matrix
        Transpose.execute(matrix);

        // STEP-2: Reverse each row in a matrix
        for(int[] row :  matrix) {
            Reverse.execute(row);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = Common.getSampleInputMatrix();

        System.out.println("Before:");
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        Common.printMatrix(matrix);

        RotateClockwise.execute(matrix);

        // Expected tranpose should be:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
        System.out.println("After:");
        Common.printMatrix(matrix);
    }
}
