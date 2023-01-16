package arrays;

import java.util.Arrays;

public class RotateArray {

    private static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    // O(1) space
    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    // O(n) space
//    public static void rotate(int[] nums, int k) {
//        int length = nums.length;
//        int[] temp = new int[length];
//        int tmpIndex = 0;
//        for (int i = length - k; i < length; i++) {
//            temp[tmpIndex++] = nums[i];
//        }
//        for (int i = 0; i < length - k; i++) {
//            temp[tmpIndex++] = nums[i];
//        }
//        for (int i = 0; i < length; i++) {
//            nums[i] = temp[i];
//        }
//    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }
}
