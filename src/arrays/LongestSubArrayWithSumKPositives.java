package arrays;

public class LongestSubArrayWithSumKPositives {

    public static int getLongestSubarray(int []a, long k){
        int maxLen = 0;
        int currSum = 0;
        int left = 0, right = 0;
        for (right = 0; right < a.length; right++) {
            currSum += a[right];
            if (currSum == k && right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            }
            while (currSum >= k) {
                currSum -= a[left];
                left++;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(getLongestSubarray(new int[]{2, 3, 5, 1, 4,1,4}, 10));
    }
}
