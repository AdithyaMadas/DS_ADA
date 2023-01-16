package stacksAndQueues;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {

    static class Pair{
        int value, count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public static int largestRectangleArea(int[] heights) {
        int[] min = new int[heights.length];
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        //find out how many is it min for in left direction
        for (int i = 0; i < heights.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && heights[i] <= stack.peek().value) {
                count += stack.pop().count;
            }
            stack.push(new Pair(heights[i], count));
            min[i] = count;
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && heights[i] <= stack.peek().value) {
                count += stack.pop().count;
            }
            stack.push(new Pair(heights[i], count));
            min[i] += count - 1;
        }

        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            area = Integer.max(area, min[i] * heights[i]);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }
}
