package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SumOfSubArrayRanges {

    static class Pair {
        int ele, count;

        public Pair(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }
    }
    public static long subArrayRanges(int[] nums) {
        int[] leftMin= new int[nums.length], leftMax= new int[nums.length], rightMin= new int[nums.length], rightMax = new int[nums.length];
//        int[] leftMin= new int[nums.length], leftMax= new int[nums.length], rightMin= new int[nums.length], rightMax = new int[nums.length];
        ArrayDeque<Pair> minStack = new ArrayDeque<>(), maxStack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (!minStack.isEmpty() && nums[i] < minStack.peek().ele) {
                count += minStack.pop().count;
            }
            leftMin[i] = count;
            minStack.push(new Pair(nums[i], count));

            count = 1;
            while (!maxStack.isEmpty() && nums[i] > maxStack.peek().ele) {
                count += maxStack.pop().count;
            }
            leftMax[i] = count;
            maxStack.push(new Pair(nums[i], count));
        }
        minStack.clear();
        maxStack.clear();
        for (int i = nums.length-1; i >= 0; i--) {
            int count = 1;
            while (!minStack.isEmpty() && nums[i] <= minStack.peek().ele) {
                count += minStack.pop().count;
            }
            rightMin[i] = count;
            minStack.push(new Pair(nums[i], count));

            count = 1;
            while (!maxStack.isEmpty() && nums[i] >= maxStack.peek().ele) {
                count += maxStack.pop().count;
            }
            rightMax[i] = count;
            maxStack.push(new Pair(nums[i], count));
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * (((long) leftMax[i] * rightMax[i]) - ((long) leftMin[i] * rightMin[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }
}
