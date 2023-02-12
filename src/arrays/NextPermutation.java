package arrays;

import java.util.Arrays;

import static arrays.SortColors.swap;

public class NextPermutation {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1 && nums[i] < nums[i - 1]) {
            i--;
        }
        i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] < nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

//    public static void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            i--;
//        }
//        if (i >= 0) {
//            int j = nums.length - 1;
//            while (nums[j] <= nums[i]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
//        reverse(nums, i + 1, nums.length - 1);
//    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        for (int i = 0; i < 8; i++) {
            nextPermutation(ints);
            System.out.println(Arrays.toString(ints));
        }
    }
}
