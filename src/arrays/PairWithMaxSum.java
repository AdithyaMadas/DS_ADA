package arrays;

public class PairWithMaxSum {
    public static long pairWithMaxSum(long arr[], long N) {
        long maxSum = -1;
        for (int i = 1; i < N; i++) {
            if (maxSum < arr[i] + arr[i - 1]) {
                maxSum = arr[i] + arr[i - 1];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(pairWithMaxSum(new long[]{5, 4, 3, 1, 6}, 5));
    }
}
