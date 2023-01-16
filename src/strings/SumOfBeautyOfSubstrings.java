package strings;

import java.util.HashMap;

public class SumOfBeautyOfSubstrings {

    public static int findBeauty(int[] charFreq) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0) {
                min = Math.min(min, charFreq[i]);
                max = Math.max(max, charFreq[i]);
            }
        }
        return max - min;
    }
    public static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] charFreq = new int[26];
            for (int j = i; j < s.length(); j++) {
                charFreq[s.charAt(j) - 'a']++;
                sum += findBeauty(charFreq);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
}
