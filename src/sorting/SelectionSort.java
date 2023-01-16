package sorting;

import java.util.Arrays;

//https://takeuforward.org/sorting/selection-sort-algorithm/

/*
* Find the minimum element in the unsorted array and swap it with the element at the beginning.
  The inner loop selects the minimum element in the unsorted array .
  In the below dry run,
*/
public class SelectionSort {

    private static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static int[] selectionSort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            int ele = x[i];
            int minIndex = i;
            int minElem = ele;
            for (int j = i+1; j < x.length; j++) {
                if (x[j] < minElem) {
                    minIndex = j;
                    minElem = x[j];
                }
            }
            if (minIndex != i) {
                swap(x, i, minIndex);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                selectionSort(new int[]{3, 7, 2, 8, 54, 1})));
    }
}
