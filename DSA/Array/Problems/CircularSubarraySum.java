package DSA.Array.Problems;

public class CircularSubarraySum {
    public static int min(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        int size = input.length;
        int total = input[0];
        int minSum = input[0], currentMinSum = input[0];
        int maxSum = input[0], currentMaxSum = input[0];

        for(int i = 1; i < size; i++) {
            int current = input[i];
            
            currentMinSum = Math.min(current, currentMinSum + current);
            minSum = Math.min(minSum, currentMinSum);

            currentMaxSum = Math.max(current, currentMaxSum + current);
            maxSum = Math.max(maxSum, currentMaxSum);

            total += current;
        }

        // Edge case: all numbers are positive, total == maxSum, total - maxSum = 0 (invalid)
        if(total == maxSum) {
            return minSum;
        }
        
        return Math.min(minSum, total - maxSum);
    }

    public static int max(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        int size = input.length;
        int total = input[0];
        int minSum = input[0], currentMinSum = input[0];
        int maxSum = input[0], currentMaxSum = input[0];

        for(int i = 1; i < size; i++) {
            int current = input[i];
            
            currentMinSum = Math.min(current, currentMinSum + current);
            minSum = Math.min(minSum, currentMinSum);

            currentMaxSum = Math.max(current, currentMaxSum + current);
            maxSum = Math.max(maxSum, currentMaxSum);

            total += current;
        }

        // If all numbers are negative, total == minSum, total - minSum = 0 (invalid)
        if(maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {
        int[] input = new int[] {8, -1, -3, 8};
        
        int minSum = CircularSubarraySum.min(input);
        System.out.println("Min Circular Subarray Sum: " + minSum);

        int maxSum = CircularSubarraySum.max(input);
        System.out.println("Max Circular Subarray Sum: " + maxSum);
    }
}
