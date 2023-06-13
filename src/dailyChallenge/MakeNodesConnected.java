package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeNodesConnected {
    public static int makeConnected(int n, int[][] connections) {
        if (connections.length + 1 < n) {
            return -1;
        }

        Map<Integer, List<Integer>> edgeList = new HashMap<>();
        for (int[] edge : connections) {
            edgeList.computeIfAbsent(edge[0], (v) -> new ArrayList<>()).add(edge[1]);
            edgeList.computeIfAbsent(edge[1], (v) -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, edgeList);
                ans++;
            }
        }
        return ans - 1;
    }

    private static void dfs(int curr, boolean[] vis, Map<Integer, List<Integer>> edgeList) {
        if (vis[curr]) {
            return;
        }
        vis[curr] = true;
        List<Integer> list = edgeList.get(curr);
        if (list != null) {
            for (int i : list) {
                dfs(i, vis, edgeList);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    }
}
