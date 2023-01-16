package binarySearch;

public class NoOfOccurences {
    static int count(int[] nums, int n, int target) {
        //similar to FindFirstLastPositionInSortedArray
        int[] toReturn = {-1, -1};
        //finding low
        int low = 0, high = n - 1;
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
        if(toReturn[0]==-1) return 0;
        //finding high
        low = 0; high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid < n - 1 && nums[mid + 1] == target) {
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
        return toReturn[1] - toReturn[0] + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(count(arr, arr.length, 2));
    }
}
