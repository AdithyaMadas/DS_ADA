package binarySearch.searchSpace;

public class FindKthPostive {
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) >> 1;
            if (arr[mid] - mid - 1 >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));
        System.out.println(findKthPositive(new int[]{3, 4, 9, 10, 12, 19, 24, 25, 27, 30}, 8));
    }
}
