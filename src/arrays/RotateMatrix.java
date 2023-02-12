package arrays;

import java.util.Arrays;

public class RotateMatrix {

    public static void rotateLeft(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 2 - i; j >= 0; j--) {
                swapLeft(matrix, i, j);
            }
        }
        reverse(matrix);
    }

    public static void swapLeft(int[][] arr, int i, int j) {
        int tempi = arr.length - j-1;
        int tempj = arr.length - i-1;
        int temp = arr[tempi][tempj];
        arr[tempi][tempj] = arr[i][j];
        arr[i][j] = temp;
    }

    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[][] matrix) {
        for (int[] arr : matrix) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                swap(arr, left++, right--);
            }
        }
    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j);
            }
        }
        reverse(matrix);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateLeft(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
