package greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int sum = 0, totalWait = 0;
        for (int i = 0; i < bt.length - 1; i++) {
            sum += bt[i];
            totalWait += sum;
        }
        return totalWait / bt.length;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4}));
    }
}
