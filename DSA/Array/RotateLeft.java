package DSA.Array;

import java.util.Arrays;

public class RotateLeft {
    // Rotate One by One (Brute Force)
    // Juggling Algorithm (Using GCD)
    // Using Extra Array : output[i] = input[(i + k) % n];
    public static void execute(int[] input, int steps) {
        int size = input.length;
        steps = steps % size;

        // STEP-1: Reverse first k elements
        Reverse.execute(input, 0, steps - 1);
        // STEP-2: Reverse Last size-k elements
        Reverse.execute(input, steps, size - 1);
        // STEP-3: Reverse entire array
        Reverse.execute(input);
    }

    public static void main(String[] args) {
        int[] input = Common.getSampleInputArray();

        System.out.println("Before:");
        System.out.println(Arrays.toString(input));

        RotateLeft.execute(input, 3);

        System.out.println("After:");
        System.out.println(Arrays.toString(input));
    }
}
