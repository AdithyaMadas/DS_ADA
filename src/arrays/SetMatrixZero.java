package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {

    public static void setZeroes(int[][] matrix) {
        boolean rowZero = false, colZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (colZero) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (rowZero) {
                matrix[0][i] = 0;
            }
        }

    }

//    public static void setZeroes(int[][] matrix) {
//        int[] rows = new int[matrix.length];
//        int[] cols = new int[matrix[0].length];
//
//        Arrays.fill(rows, 1);
//        Arrays.fill(cols, 1);
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    rows[i] = 0;
//                    cols[j] = 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (rows[i] == 0 || cols[j] == 0) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
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
//        int[][] arr = {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
