package graphs;

import java.util.HashSet;
import java.util.Set;

public class IsBipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int color, int currNode) {
        colors[currNode] = color;
        for (int nei : graph[currNode]) {
            if (colors[nei] == color) {
                return false;
            } else if (colors[nei] == 0 && !dfs(graph, colors, -color, nei)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1}, {0, 3}, {3}, {1, 2}}));

//        0 - 1 - 3 - 2
//        a: 0,3
//        b: 1,2
    }
}
