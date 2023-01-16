package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSets {
    public static Integer[] intersection(int[] x, int[] y) {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < x.length && j < y.length) {
            if (x[i] == y[j]) {
                intersection.add(x[i]);
                i++;
                j++;
            } else if (x[i] < y[j]) {
                i++;
            } else {
                j++;
            }
        }
        Integer[] arr = new Integer[intersection.size()];
        arr = intersection.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(
                new int[]{1, 2, 3, 4},
                new int[]{2, 3, 5, 6}
        )));
    }
}
