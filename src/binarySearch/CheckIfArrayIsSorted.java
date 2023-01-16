package binarySearch;

public class CheckIfArrayIsSorted {
    static boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50,49};
        System.out.println(arraySortedOrNot(arr, arr.length));
    }
}
