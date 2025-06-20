package DSA.Array;

import java.util.Arrays;

public class RotateRight {
    // Rotate One by One (Brute Force)
    // Juggling Algorithm (Using GCD)
    // Using Extra Array : output[(i + k) % n] = input[i];
    public static void execute(int[] input, int steps) {
        int size = input.length;
        steps = steps % size;

        // STEP-1: Reverse first size-k elements
        Reverse.execute(input, 0, (size - steps) - 1);
        // STEP-2: Reverse Last k elements
        Reverse.execute(input, size - steps, size - 1);
        // STEP-3: Reverse entire array
        Reverse.execute(input);
    }

    public static void main(String[] args) {
        int[] input = Common.getSampleInputArray();

        System.out.println("Before:");
        System.out.println(Arrays.toString(input));

        RotateRight.execute(input, 3);

        System.out.println("After:");
        System.out.println(Arrays.toString(input));
    }
}
