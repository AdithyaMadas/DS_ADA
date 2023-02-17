package recursion;

public class PerfectSum {

    static int res, zeros;

    public static int perfectSum(int arr[], int n, int sum) {
        res = 0;
        countZeros(arr);
        getCount(arr, 0, 0, sum);
        return res;
    }

    private static void countZeros(int[] arr) {
        zeros = 0;
        for (int i : arr) {
            if (i == 0) {
                zeros++;
            }
        }
    }

    private static void getCount(int[] arr, int currIndex, int currSum, int target) {
        if (currSum == target) {
            res += zeros + 1;
            return;
        }
        if (arr.length == currIndex || currSum > target) {
            return;
        }
        getCount(arr, currIndex + 1, currSum, target);
        getCount(arr, currIndex + 1, currSum + arr[currIndex], target);
    }

    public static void main(String[] args) {
        System.out.println(perfectSum(new int[]{1, 2, 1}, 6, 2));
        System.out.println(perfectSum(new int[]{2, 3, 5, 6, 8, 10, 0}, 6, 10));
        System.out.println(perfectSum(new int[]{1, 2, 3, 4, 5}, 6, 10));
    }
}
