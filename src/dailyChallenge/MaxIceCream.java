package dailyChallenge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxIceCream {
    public static int maxIceCream(int[] costs, int coins) {
        if(costs.length==0) return 0;
        int[] costBucket = new int[Arrays.stream(costs).max().getAsInt() + 1];
        Arrays.stream(costs).forEach(e -> costBucket[e]++);
        int ans = 0;
        for (int i = 1; i < costBucket.length; i++) {
            if (coins < i) {
                break;
            }
            if (costBucket[i] > 0) {
                ans += Math.min(costBucket[i], coins / i); // buy as much as possible or how much you can afford
                coins -= Math.min(coins, costBucket[i] * i);
            }
        }
        return ans;
    }


    /*public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i : costs) {
            if (coins < i) {
                break;
            }
            coins -= i;
            res++;
        }
        return res;
    }*/

    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{}, 5));
    }
}
