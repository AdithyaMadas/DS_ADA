package recursion;

public class PerfectSum {

    static int res;

    public static int perfectSum(int arr[], int n, int sum) {
        res = 0;
        getCount(arr, 0, 0,  sum);
        return res;
    }

    private static void getCount(int[] arr, int currIndex, int currSum, int target) {
        if (currSum == target) {
            res++;
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
        System.out.println(perfectSum(new int[]{2, 3, 5, 6, 8, 10}, 6, 10));
        System.out.println(perfectSum(new int[]{1, 2, 3, 4, 5}, 6, 10));
    }
}
