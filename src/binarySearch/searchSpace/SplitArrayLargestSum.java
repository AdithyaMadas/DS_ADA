package binarySearch.searchSpace;

public class SplitArrayLargestSum {

    public static int[] minAndSumOfArray(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i : nums) {
            sum += i;
            if (i < min) {
                min = i;
            }
        }
        return new int[]{min, sum};
    }

    public static int splitArray(int[] nums, int k) {
        int[] ints = minAndSumOfArray(nums);
        int low = ints[0], high = ints[1];
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] nums, int capacity, int k) {
        int currSum = 0;
        for (int i : nums) {
            if (i > capacity) return false;
            currSum += i;
            if (currSum > capacity) {
                k--;
                if (k == 0) {
                    return false;
                }
                currSum = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
