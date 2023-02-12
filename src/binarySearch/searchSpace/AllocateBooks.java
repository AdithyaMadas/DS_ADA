package binarySearch.searchSpace;

import java.util.Arrays;

public class AllocateBooks {
    public static int findPages(int[] A, int N, int M) {
        if (A.length < M) {
            return -1;
        }
        int low = Arrays.stream(A).min().getAsInt(), high = Arrays.stream(A).sum();
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(A, N, M, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] a, int n, int m, int mid) {
        int currPages = 0, allocatedStudents = 1;
        for (int i : a) {
            if(i>mid) return false;
            if (currPages + i > mid) {
                allocatedStudents++;
                currPages = i;
            } else {
                currPages += i;
            }
        }
        if (allocatedStudents > m) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(findPages(new int[]{12, 34, 67, 90}, 4, 2));
        System.out.println(findPages(new int[]{15,17,20}, 4, 2));
        System.out.println(findPages(new int[]{12, 34, 67, 90}, 4, 5));
    }
}
