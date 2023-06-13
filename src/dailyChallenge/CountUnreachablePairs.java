package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUnreachablePairs {
    public static long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        ArrayList<Integer> groupSize = new ArrayList<>();
        long ans = 0;
        int o = n;
        for (int i = 0; i < o; i++) {
            if (!vis[i]) {
                int reached = dfs(map, vis, i);
                ans += (long) reached * (n - reached);
                n -= reached;
            }
        }
        return ans;
    }

    private static int dfs(Map<Integer, List<Integer>> map, boolean[] vis, int curr) {
        vis[curr] = true;
        int visNodes = 1;
        for (int i : map.getOrDefault(curr, new ArrayList<>())) {
            if (!vis[i]) {
                visNodes+= dfs(map, vis, i);
            }
        }
        return visNodes;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));
        System.out.println(countPairs(4, new int[][]{}));
    }
}
