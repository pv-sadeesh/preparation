package DSA.Array;

public class Kadane {
    public static int execute(int[] input) {
        int size = input.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for(int i = 0; i < size; i++) {
            currentSum = Math.max(input[i], currentSum + input[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = Kadane.execute(input);
        // Expected result is 6
        System.out.println("Result: " + maxSum);
    }
}
