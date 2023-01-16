package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNumberOfSubstrings {
    static long substrCount(String A, int K) {
        int count = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < A.length(); i++) {
            int dist_count = 0;
            Arrays.fill(cnt, 0);
            for (int j = i; j < A.length(); j++) {
                if (cnt[A.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }
                cnt[A.charAt(j) - 'a']++;
                if (dist_count == K) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(substrCount("aba", 2));
    }
}
