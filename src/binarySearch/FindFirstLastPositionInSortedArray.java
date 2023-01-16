package binarySearch;

import java.util.Arrays;

public class FindFirstLastPositionInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] toReturn = {-1, -1};
        //finding low
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    toReturn[0] = mid;
                    break;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //finding high
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    toReturn[1] = mid;
                    break;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return toReturn;
    }

    public static void main(String[] args) {
        int[] arr = {5,5, 7, 7, 8, 8,8,8,8,9, 10,10};
        System.out.println(Arrays.toString(searchRange(arr, 5)));
    }
}
