package binarySearch.searchSpace;

public class KokoEatingBananas {

    static int numberOfHours(int[] arr, int hours) {
        int count = 0;
        for (int i : arr) {
            count += Math.ceil(i / (double) hours);
        }
        return count;
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = max(piles);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (numberOfHours(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] x = {30,11,23,4,20};
        System.out.println(minEatingSpeed(x, 6));
    }
}
