package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximalRectangle {

    static class Pair{
        int value, count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public static int largestRectangleArea(int[] heights) {
        int[] min = new int[heights.length];
        ArrayDeque<LargestRectangleInHistogram.Pair> stack = new ArrayDeque<>();
        //find out how many is it min for in left direction
        for (int i = 0; i < heights.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && heights[i] <= stack.peek().value) {
                count += stack.pop().count;
            }
            stack.push(new LargestRectangleInHistogram.Pair(heights[i], count));
            min[i] = count;
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && heights[i] <= stack.peek().value) {
                count += stack.pop().count;
            }
            stack.push(new LargestRectangleInHistogram.Pair(heights[i], count));
            min[i] += count - 1;
        }

        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            area = Integer.max(area, min[i] * heights[i]);
        }
        return area;
    }

    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            max = Integer.max(max, largestRectangleArea(height));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
