package slidingWindowAndTwoPointer;

import java.util.LinkedList;
import java.util.Queue;

public class longestOnes {

    public static int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }


    /*public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroCount = 0, maxLen = 0;
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
                zeroIndex.add(right);
            }
            if (zeroCount > k) {
                left = zeroIndex.remove() + 1;
                zeroCount--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }*/

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
