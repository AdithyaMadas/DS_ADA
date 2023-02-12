package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, lastElem = -1;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                res.add(arr1[i]);
                lastElem = arr1[i];
            } else {
                res.add(arr2[j]);
                lastElem = arr2[j];
            }
            while (i < n && arr1[i] == lastElem) {
                i++;
            }
            while (j < m && arr2[j] == lastElem) {
                j++;
            }
        }


        while (i < n) {
            res.add(arr1[i]);
            lastElem = arr1[i];
            while (i < n && arr1[i] == lastElem) {
                i++;
            }
        }
        while (j < m) {
            res.add(arr2[j]);
            lastElem = arr2[j];
            while (j < m && arr2[j] == lastElem) {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}, 5, 3));
        System.out.println(findUnion(new int[]{2, 2, 3, 4, 5}, new int[]{1, 1, 2, 3, 4}, 5, 5));
        System.out.println(findUnion(new int[]{1, 1, 1, 1, 1}, new int[]{2, 2, 2, 2, 2}, 5, 5));

    }
}
