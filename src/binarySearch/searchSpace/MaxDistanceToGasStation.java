package binarySearch.searchSpace;

import java.text.DecimalFormat;

public class MaxDistanceToGasStation {
    public static double findSmallestMaxDist(int stations[],int K) {
        double left = 0, right = stations[stations.length - 1] - stations[0];
        while (right - left >= 1e-5) {
            double mid = (left + right) / 2.0;
            if (isPossible(mid, stations, K)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        double format = Double.parseDouble(String.format("%.2f", left));
        return format;
    }

    private static boolean isPossible(double mid, int[] stations, int k) {
        int stationsToAdd = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            stationsToAdd += Math.floor((stations[i + 1] - stations[i]) / mid);
        }
        return stationsToAdd <= k;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestMaxDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(findSmallestMaxDist(new int[]{3,6,12,19,33,44,67,72,89,95}, 2));
    }
}
