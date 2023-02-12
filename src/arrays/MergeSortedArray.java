package arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, p = nums1.length - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums2[i2] > nums1[i1]) {
                nums1[p--] = nums2[i2--];
            } else {
                nums1[p--] = nums1[i1--];
            }
        }
        while (i2 >= 0) {
            nums1[p--] = nums2[i2--];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,0,0,0};
        merge(ints, 3, new int[]{1,2,3}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
