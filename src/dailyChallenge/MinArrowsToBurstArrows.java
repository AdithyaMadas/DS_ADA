package dailyChallenge;

import java.util.Arrays;

public class MinArrowsToBurstArrows {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1, value = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (value >= points[i][0]) {
                continue;
            }
            arrow++;
            value = points[i][1];
        }
        return arrow;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]
                {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
