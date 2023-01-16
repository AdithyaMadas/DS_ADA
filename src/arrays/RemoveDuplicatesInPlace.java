package arrays;

import java.util.Arrays;

public class RemoveDuplicatesInPlace {
    public static int removeDuplicates(int[] x) {
        int i = 0;
        for (int j = 1; j < x.length; j++) {
            if (x[i] != x[j]) {
                i++;
                x[i] = x[j];
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6};
        int i = removeDuplicates(ints);
        for (int q = 0; q < i; q++) {
            System.out.println(ints[q]);
        }
    }
}
