package binarySearch;

public class SingleElementInSortedArray {

    public static boolean isUnique(int[] nums, int i) {
        if (i == 0) {
            return nums[0] != nums[1];
        } else if (i == nums.length - 1) {
            return nums[nums.length - 2] != nums[nums.length - 1];
        } else {
            return nums[i] != nums[i - 1] && nums[i] != nums[i + 1];
        }
    }

    public static int getLeftIndex(int[] nums, int i) {
        if (i == 0) {
            return 0;
        }

        if (nums[i] == nums[i - 1]) {
            return i - 1;
        }
        return i;
    }

    public static int getRightIndex(int[] nums, int i) {
        if (i == nums.length - 1) {
            return i;
        }

        if (nums[i] == nums[i + 1]) {
            return i + 1;
        }
        return i;
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isUnique(nums, mid)) {
                return nums[mid];
            } else {
                int left = getLeftIndex(nums, mid);
                if (left % 2 != 0) {
                    high = getLeftIndex(nums, mid) - 1;
                } else {
                    low = getRightIndex(nums, mid) + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(singleNonDuplicate(nums));
    }
}
