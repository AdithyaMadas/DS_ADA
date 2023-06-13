package slidingWindowAndTwoPointer.redo;

public class maxPoints {
    public static int maxScore(int[] cardPoints, int k) {
        int left = 0, maxSum = 0;
        while (k > 0) {
            maxSum += cardPoints[left++];
            k--;
        }
        int currSum = maxSum;
        while (left > 0) {
            currSum -= cardPoints[--left];
            currSum += cardPoints[cardPoints.length - ++k];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }
}
