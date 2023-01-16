package arrays;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSubSeq {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int i : nums) {
            map.add(i);
        }
        int maxSeq = 0;
        for (int i : nums) {
            if (map.contains(i - 1)) {
                continue;
            }
            int currSeq = 0;
            while (map.contains(i++)) {
                currSeq++;
            }
            if (currSeq > maxSeq) {
                maxSeq = currSeq;
            }
        }
        return maxSeq;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
