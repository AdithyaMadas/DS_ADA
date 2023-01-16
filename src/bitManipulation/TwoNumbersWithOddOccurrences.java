package bitManipulation;

import java.util.Arrays;

public class TwoNumbersWithOddOccurrences {
    public static int[] twoOddNum(int Arr[], int N) {
        int xor = 0, xor1 = 0, xor2 = 0, count = 1;
        for (int i : Arr) {
            xor ^= i;
        }

        while (true) {
            if ((xor & (1 << count)) != 0) {
                break;
            } else {
                count++;
            }
        }

        for (int i : Arr) {
            if ((i & (1 << count)) != 0) {
                xor1 ^= i;
            } else {
                xor2 ^= i;
            }
        }
        return (xor1 < xor2) ? new int[]{xor1, xor2} : new int[]{xor2, xor1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoOddNum(new int[]{1, 7, 5, 7, 5, 4, 7, 4}, 8)));
    }
}
