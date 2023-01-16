package arrays;

import java.util.Arrays;

public class SecondLargestAndSmallest {

    public static int[] secondSmallestAndLargest(int[] x) {
        if (x.length == 0 || x.length == 1) {
            return new int[]{-1, -1};
        }
        int maxElem = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int minElem = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i : x) {
            if (i > maxElem) {
                secondMax = maxElem;
                maxElem = i;
            }else if (i > secondMax) {
                secondMax = i;
            }
            if (i < minElem) {
                secondMin = minElem;
                minElem = i;
            } else if (i < secondMin) {
                secondMin = i;
            }
        }
        return new int[]{secondMin, secondMax};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(secondSmallestAndLargest((new int[]{3, 12, 56, 85, 20}))));
    }
}
