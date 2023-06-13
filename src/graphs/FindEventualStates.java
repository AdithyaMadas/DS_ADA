package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        short[] vis = new short[graph.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(vis, graph, i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean dfs(short[] vis, int[][] graph, int curr) {
        if (vis[curr] > 0) {
            return vis[curr] == 2;
        }

        vis[curr] = 1;
        for (int i : graph[curr]) {
            if (!dfs(vis, graph, i)) {
                return false;
            }
        }
        vis[curr] = 2;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
    }
}
