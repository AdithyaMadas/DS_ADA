package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeetings {
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = start[i];
            times[i][1] = end[i];
        }
        Arrays.sort(times, Comparator.comparingInt(o -> o[1]));
        int ans = 1, prevEnd = times[0][1];
        for (int i = 1; i < n; i++) {
            if (times[i][0] > prevEnd) {
                ans++;
                prevEnd = times[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}, 6));
    }
}
