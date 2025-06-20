package DSA.Array;

public class Transpose {
    public static void execute(int[][] matrix) {
        int size = matrix.length;
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = Common.getSampleInputMatrix();

        System.out.println("Before:");
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        Common.printMatrix(matrix);

        Transpose.execute(matrix);

        // Expected tranpose should be:
        // [1, 4, 7]
        // [2, 5, 8]
        // [3, 6, 9]
        System.out.println("After:");
        Common.printMatrix(matrix);
    }
}
