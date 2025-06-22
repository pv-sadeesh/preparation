package DSA.Array.Problems;

public class SubarraySum {
    public static int min(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for(int current : input) {
            currentSum = Math.min(currentSum + current, current);
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }

    public static int max(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }
        
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int current : input) {
            currentSum = Math.max(currentSum + current, current);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] input = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int minSum = SubarraySum.min(input);
        System.out.println("Min Subarray Sum: " + minSum);

        int maxSum = SubarraySum.max(input);
        System.out.println("Max Subarray Sum: " + maxSum);
    }
}
