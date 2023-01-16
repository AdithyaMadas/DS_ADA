package sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static int[] bubbleSort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
                if (x[j] > x[j + 1]) {
                    swap(x, j, j + 1);
                }
            }
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                bubbleSort(new int[]{3, 7, 2, 8, 54, 1})));
    }
}
