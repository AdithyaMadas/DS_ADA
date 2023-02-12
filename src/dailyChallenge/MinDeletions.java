package dailyChallenge;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class MinDeletions {
    public static int minDeletions(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        charCount = Arrays.stream(charCount).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int res = 0;
        for (int i = 0; i < 25; i++) {
            if (charCount[i] == 0) {
                break;
            }
            if (charCount[i] <= charCount[i + 1]) {
                if (charCount[i] - 1 == 0) {
                    res += countOnes(charCount, i + 1);
                    break;
                }
                res += charCount[i + 1] - (charCount[i] - 1);
                charCount[i + 1] = charCount[i] - 1;
            }
        }
        return res;
    }

    private static int countOnes(int[] charCount, int i) {
        int j = 0, res = 0;
        while (charCount[i + j] != 0     && (i + j) < charCount.length) {
            res += charCount[i + j];
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("abcabc"));
        System.out.println(minDeletions("bbcebab"));
        System.out.println(minDeletions("ceabaacb"));
        System.out.println(minDeletions("aaabbbcc"));
    }
}
