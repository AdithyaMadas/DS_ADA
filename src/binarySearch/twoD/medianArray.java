package binarySearch.twoD;

public class medianArray {


    static int countLessThanOrEqualTo(int[] matrix, int x) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int median(int matrix[][], int R, int C) {
        int low = 0, high = 2000;
        int medianIndex = (R * C) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int[] i : matrix) {
                count += countLessThanOrEqualTo(i, mid);
            }
            if (count <= medianIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] x = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(median(x, 3, 3));
    }
}
