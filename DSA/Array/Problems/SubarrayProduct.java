package DSA.Array.Problems;

public class SubarrayProduct {
    public static int min(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        int size = input.length;
        int minProduct = input[0];
        int currentMinProduct = input[0];
        int currentMaxProduct = input[0];

        for(int i = 1; i < size; i++) {
            int current = input[i];

            // Swap because multiplying by a negative flips min and max
            if(current < 0) {
                int temp = currentMinProduct;
                currentMinProduct = currentMaxProduct;
                currentMaxProduct = temp;
            }

            currentMinProduct = Math.min(current, currentMinProduct * current);
            currentMaxProduct = Math.max(current, currentMaxProduct * current);
            minProduct = Math.min(minProduct, currentMinProduct);
        }

        return minProduct;
    }

    public static int max(int[] input) {
        if(input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        int size = input.length;
        int maxProduct = input[0];
        int currentMinProduct = input[0];
        int currentMaxProduct = input[0];

        for(int i = 1; i < size; i++) {
            int current = input[i];

            // Swap because multiplying by a negative flips min and max
            if(current < 0) {
                int temp = currentMinProduct;
                currentMinProduct = currentMaxProduct;
                currentMaxProduct = temp;
            }

            currentMinProduct = Math.min(current, currentMinProduct * current);
            currentMaxProduct = Math.max(current, currentMaxProduct * current);
            maxProduct = Math.max(maxProduct, currentMaxProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int minProduct = SubarrayProduct.min(input);
        System.out.println("Min Subarray Product: " + minProduct);

        int maxProduct = SubarrayProduct.max(input);
        System.out.println("Max Subarray Product: " + maxProduct);
    }
}
