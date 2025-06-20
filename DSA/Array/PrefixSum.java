package DSA.Array;

import java.util.Arrays;

public class PrefixSum {
    public static int[] execute(int[] input) {
        int sum = 0;
        int size = input.length;
        int[] prefixSum = new int[size];

        for(int i = 0; i < size; i++) {
            sum += input[i];
            prefixSum[i] = sum;
        }

        return prefixSum;
    }

    public static void main(String[] args) {
        int[] input = Common.getSampleInputArray();

        System.out.println("Before:");
        System.out.println(Arrays.toString(input));

        int[] prefixSum = PrefixSum.execute(input);

        System.out.println("After:");
        System.out.println(Arrays.toString(prefixSum));
    }
}
