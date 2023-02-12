package binarySearch.searchSpace;

import java.util.Arrays;

public class MinimumDaysForBouquet {
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }
        int low = bloomDay[0], high = bloomDay[0];
        for (int i : bloomDay) {
            if (i < low) {
                low = i;
            } else if (i > high) {
                high = i;
            }
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (continuousFlowersAvailable(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean continuousFlowersAvailable(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        for (int i : bloomDay) {
            if (i <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                m--;
                count = 0;
                if (m == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }
}
