package binarySearch;

//https://leetcode.com/problems/find-peak-element/#:~:text=Find%20Peak%20Element%20%2D%20LeetCode&text=A%20peak%20element%20is%20an,to%20any%20of%20the%20peaks.
public class PeakElement {

    public static int isPeak(int[] nums, int index, int n) {
        if (index == 0) {
            if (nums[index] > nums[index + 1]) {
                return 0;
            } else {
                return 1;
            }
        } else if (index == n - 1) {
            if (nums[index - 1] < nums[index]) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (nums[index] > nums[index + 1] && nums[index] > nums[index - 1]) {
                return 0;
            } else if (nums[index - 1] < nums[index] && nums[index] < nums[index + 1]) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return nums[1];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPeak(nums, mid,nums.length) == 0) {
                return mid;
            } else if (isPeak(nums, mid, nums.length) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }
}
