package arrays;

import java.util.Arrays;

public class ReversePairs {

    static long ans;
    public static int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, nums.length);
        return (int) ans;
    }

    private static void mergeSort(int[] nums, int n) {
        if (n < 2) {
            return;
        }
        int mid = (n / 2);
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, n - mid);
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        for (int i = 0, j = 0; i < mid; i++) {
            while (j < n - mid && left[i] / 2.0 > right[j]) j++;
            ans += j;
        }

//        for (int j = 0; j < n - mid; j++) {
//            int i = mid - 1;
//            if (right[j] * 2 > left[i]) {
//                break;
//            }
//            while (i >= 0 && (long) right[j] * (long) 2 < left[i]) {
//                i--;
//                ans++;
//            }
//        }
        merge(nums, left, right, mid, n - mid);
    }

    private static void merge(int[] nums, int[] left, int[] right, int lLen, int rLen) {
        int i = 0, l = 0, r = 0;
        while (l < lLen && r < rLen) {
            if (left[l] < right[r]) {
                nums[i++] = left[l++];
            } else  {
                nums[i++] = right[r++];
            }
        }

        while (l < lLen) {
            nums[i++] = left[l++];
        }

        while (r < rLen) {
            nums[i++] = right[r++];
        }
    }


    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
