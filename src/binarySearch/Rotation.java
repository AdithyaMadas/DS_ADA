package binarySearch;

public class Rotation {
    static int findKRotation(int arr[], int n) {
        if (arr[0] <= arr[arr.length - 1]) {
            return 0;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (rightSorted(arr, mid, n)) {
                if (arr[mid - 1] > arr[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static boolean rightSorted(int[] arr, int mid, int n) {
        return arr[mid] <= arr[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{4, 5,1, 2, 3}, 5));
    }
}
