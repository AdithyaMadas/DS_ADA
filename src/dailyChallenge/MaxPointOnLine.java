package dailyChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaxPointOnLine {
    public static int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slope = ((double) points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                if (slope == -0.0 || slope == Double.NEGATIVE_INFINITY) {
                    slope = Math.abs(slope);
                }
//                System.out.println(slope);
                if (map.containsKey(slope)) {
                    int noOfPoints = map.get(slope) + 1;
                    map.put(slope, noOfPoints);
                    if (noOfPoints > max) {
                        max = noOfPoints;
                    }
                } else {
                    map.put(slope, 2);
                }
            }
        }
        return Math.max(max, 2);
    }


    public static void main(String[] args) {
//        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        System.out.println(maxPoints(new int[][]{{2,3},{3,3},{-5,3}}));

    }
}
