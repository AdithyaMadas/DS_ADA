package dailyChallenge;

import java.util.Arrays;

public class maxSatisfaction {

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxSat = Integer.MIN_VALUE;
        for (int i = 0; i < satisfaction.length; i++) {
            int sat = getSatisfactionFromI(satisfaction, i);
            maxSat = Math.max(maxSat, sat);
        }
        return Math.max(maxSat, 0);
    }

    private static int getSatisfactionFromI(int[] satisfaction, int start) {
        int sat = 0;
        for (int i = start, reli = 1; i < satisfaction.length; i++, reli++) {
            sat += satisfaction[i] * reli;
        }
        return sat;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(maxSatisfaction(new int[]{4, 3, 2}));
    }
}
