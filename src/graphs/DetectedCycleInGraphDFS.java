package graphs;

import java.util.*;

public class DetectedCycleInGraphDFS {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            if (dfs(adj, i, new boolean[V], i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited, int parent) {
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (i != parent) {
                if (dfs(adj, i, visited, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>() {{
//            add(1);
        }});
        list.add(new ArrayList<Integer>() {{
//            add(0);
            add(2);
//            add(4);
        }});
        list.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});
        list.add(new ArrayList<Integer>() {{
            add(2);
//            add(4);
        }});
        list.add(new ArrayList<Integer>() {{
//            add(1);
//            add(3);
        }});
        System.out.println(isCycle(4, list));
    }
}
