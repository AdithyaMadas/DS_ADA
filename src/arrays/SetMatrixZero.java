package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {

    public static void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 0 || cols[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /*
    // if numbers are only positive
    public static void makeRowsColumnsZero(int[][] nums, int i, int j) {
        for (int q = 0; q < nums[0].length; q++) {
            if (nums[i][q] != 0) {
                nums[i][q] = Integer.MIN_VALUE;
            } else {
                nums[i][q] = 0;
            }
        }
        for (int q = 0; q < nums.length; q++) {
            if (nums[q][j] != 0) {
                nums[q][j] = Integer.MIN_VALUE;
            } else {
                nums[q][j] = 0;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    makeRowsColumnsZero(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }*/

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
