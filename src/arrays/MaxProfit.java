package arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int minTillNow = Integer.MAX_VALUE, maxProfit = 0;
        for (int i : prices) {
            if (i < minTillNow) {
                minTillNow = i;
            } else {
                int profit = i - minTillNow;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
