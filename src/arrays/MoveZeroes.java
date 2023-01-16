package arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{0, 1, 0, 3, 12};
        moveZeroes(x);
        System.out.println(Arrays.toString(x));
    }
}
