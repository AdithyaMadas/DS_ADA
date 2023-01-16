package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> arr = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int i = left; top <= bottom && i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            top++;
            for (int i = top; left <= right && i <= bottom; i++) {
                arr.add(matrix[i][right]);
            }
            right--;
            for (int i = right; top <= bottom && i >= left; i--) {
                arr.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; left <= right && i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            left++;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> integers = spiralOrder(arr);
        System.out.println(integers);
    }
}
