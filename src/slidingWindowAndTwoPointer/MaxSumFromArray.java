package slidingWindowAndTwoPointer;

public class MaxSumFromArray {

    public static int maxScore(int[] cardPoints, int k) {
        int maxSum = 0, left = 0, right = cardPoints.length - k;
        while (k > 0) {
            maxSum += cardPoints[cardPoints.length - k];
            k--;
        }
        if(right<0) return maxSum;
        int currSum = maxSum;
        while (right < cardPoints.length) {
            currSum += cardPoints[left++] - cardPoints[right++];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    //brute force
    /*public static int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length - 1, score = 0;
        while (left <= right && k > 0) {
            if (findBetterSum(cardPoints, left, right, k)) {
                score += cardPoints[left++];
            } else {
                score += cardPoints[right--];
            }
            k--;
        }
        return score;
    }

    private static boolean findBetterSum(int[] cardPoints, int left, int right, int k) {
        int lSum = 0, rSum = 0, k2 = k;
        while (left < cardPoints.length && k-- > 0) {
            lSum += cardPoints[left++];
        }

        while (right >= 0 && k2-- > 0) {
            rSum += cardPoints[right--];
        }
        return lSum > rSum;
    }*/


    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30}, 8));

    }
}
