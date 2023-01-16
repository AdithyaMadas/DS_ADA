package binarySearch.searchSpace;

public class capacityToShipWithinTwoDays_1011 {

    public static int[] findSumAndMax(int[] w) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i : w) {
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        return new int[]{sum, max};
    }

    public static int noOfDays(int[] weights, int capacity) {
        int days=0, currCap = 0;
        for (int i : weights) {
            currCap += i;
            if (currCap > capacity) {
                currCap = i;
                days++;
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int[] sumMax = findSumAndMax(weights);
        int low = sumMax[1], high = sumMax[0];
        while (low < high) {
            int mid = (low + high) / 2;
            if (noOfDays(weights, mid) < days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
