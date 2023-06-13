package dailyChallenge;

import java.util.Arrays;

public class MinTrips {
    public static long minimumTime(int[] time, int totalTrips) {
        int asInt = Arrays.stream(time).min().getAsInt();
        long min = asInt, max = (long) totalTrips * asInt;
        while (min < max) {
            long mid = (min + max) >> 1;
            if (getTrips(time, mid) < totalTrips) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private static long getTrips(int[] time, long mid) {
        long count = 0;
        for (int i : time) {
            count += mid / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{5, 10, 10}, 9));
        System.out.println(minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(minimumTime(new int[]{10000}, 10000000));

    }
}
