package sorting;

import java.util.Arrays;

public class InsertionSort {

    private static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static int[] insertionSort(int[] x) {
        for (int i = 1; i < x.length; i++) {
            for (int j = i; j > 0 && x[j-1] > x[j]; j--) {
                    swap(x, j - 1, j);
            }
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                insertionSort(new int[]{3, 7, 2, 8, 54, 1})));
    }
}
