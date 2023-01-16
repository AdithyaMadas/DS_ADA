package arrays;

public class search2DMatrix {

    public static boolean binarySearch(int[] x, int target) {
        int low = 0, high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x[mid] == target) {
                return true;
            } else if (x[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int len = matrix[0].length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[mid][len]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                break;
            }
        }
        return binarySearch(matrix[(top + bottom) / 2], target);
    }

    public static void main(String[] args) {
//        int[][] x = new int[][]{{1}, {3}};
        int[][] x = new int[][]{{1, 3, 5, 7},{
            10, 11, 16, 20
        },{
            23, 30, 34, 60
        }};
        System.out.println(searchMatrix(x, 13));
    }
}
