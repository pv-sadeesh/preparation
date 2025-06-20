package DSA.Array;

public class RotateAnticlockwise {
    public static void execute(int[][] matrix) {
        // STEP-1: Reverse each row in a matrix
        for(int[] row :  matrix) {
            Reverse.execute(row);
        }

        // STEP-2: Transpose the matrix
        Transpose.execute(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = Common.getSampleInputMatrix();

        System.out.println("Before:");
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        Common.printMatrix(matrix);

        RotateAnticlockwise.execute(matrix);

        System.out.println("After:");
        // [3, 6, 9]
        // [2, 5, 8]
        // [1, 4, 7]
        Common.printMatrix(matrix);
    }
}
