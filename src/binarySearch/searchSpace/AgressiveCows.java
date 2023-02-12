package binarySearch.searchSpace;

import java.util.Arrays;

public class AgressiveCows {
    public static int solve(int n, int k, int[] stalls) {
        if (k > n) {
            return -1;
        }
        if (k == 1) {
            return 0;
        }

        int low = 1, high = Arrays.stream(stalls).max().getAsInt();
        Arrays.sort(stalls);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(stalls, n, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] stalls, int n, int k, int mid) {
        k--;
        int prevStall = stalls[0];
        for (int i = 1; i < n; i++) {
            int dis = stalls[i] - prevStall;
            if (dis > mid) {
                k--;
                prevStall = stalls[i];
                if (k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(5, 3, new int[]{1, 2, 4, 8, 9}));
        System.out.println(solve(5, 3, new int[]{10, 1, 2, 7, 5}));
    }
}
