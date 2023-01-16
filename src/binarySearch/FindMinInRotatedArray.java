package binarySearch;

public class FindMinInRotatedArray {

    public static boolean isSorted(int[] nums, int left, int right) {
        return nums[left] <= nums[right];
    }
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isSorted(nums, low, mid)) {
                min = Integer.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Integer.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
}
