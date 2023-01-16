package greedy;

import java.util.Arrays;

public class FindCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_index = 0, ans = 0;
        for (int q = 0; q < s.length; q++) {
            if (s[q] >= g[g_index]) {
                ans++;
                g_index++;
            }
            if (g_index == g.length) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
