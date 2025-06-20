package DSA.Array;

import java.util.Arrays;

public class Reverse {
    public static void execute(int[] input) {
        int left = 0;
        int right = input.length - 1;

        while(left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;

            left++; 
            right--;
        }
    }

    public static void main(String[] args) {
        int[] input = Common.getSampleInputArray();

        System.out.println("Before:");
        System.out.println(Arrays.toString(input));

        Reverse.execute(input);
        
        System.out.println("After:");
        System.out.println(Arrays.toString(input));
    }
}
