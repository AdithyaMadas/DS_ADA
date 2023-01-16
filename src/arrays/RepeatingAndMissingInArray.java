package arrays;

import java.util.Arrays;

public class RepeatingAndMissingInArray {

    private static int[] missingAndRepeating(int[] x) {
        int n = x.length;
        int xor = 0;
        for (int i : x) {
            xor ^= i;
        }

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        //find least sig bit
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) != 0) {
                break;
            }
            count++;
            xor = xor >> 1;
        }

        int xor1 = 0, xor2 = 0;
        for (int i : x) {
            if ((i & (1 << count)) != 0) {
                xor1 = xor1 ^ i;
            } else {
                xor2 = xor2 ^ i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & (1 << count)) != 0) {
                xor1 = xor1 ^ i;
            } else {
                xor2 = xor2 ^ i;
            }
        }
        return new int[]{xor1, xor2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingAndRepeating(new int[]{1, 1, 2, 4, 5})));
    }
}
