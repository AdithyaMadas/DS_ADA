package arrays;
import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
public class SortColors {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid++, low++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }


    // O(2N) -> 2 passes are required, we can do it in 1 pass
    /*public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i : nums) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int i = 0;
        while (count0-- > 0) {
            nums[i++] = 0;
        }
        while (count1-- > 0) {
            nums[i++] = 1;
        }
        while (count2-- > 0) {
            nums[i++] = 2;
        }
    }*/

    public static void main(String[] args) {
        int[] ints = {2};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
}
