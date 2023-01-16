package arrays;

//https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCon = 0, currentCon = 0;
        for (int i : nums) {
            if (i == 1) {
                currentCon++;
            } else {
                maxCon = Math.max(currentCon, maxCon);
                currentCon = 0;
            }
        }
        return Math.max(currentCon, maxCon);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0, 0, 0}));
    }
}
