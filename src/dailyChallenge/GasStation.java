package dailyChallenge;

import java.util.Arrays;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0, surplus = 0, start = 0;
        for (int i = 0; i < cost.length; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                start = i + 1;
                surplus = 0;
            }
        }
        return totalSurplus > 0 ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
