package graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DetectCycle {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] currPath = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, currPath, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        visited[curr] = true;
        vis[curr] = true;
        for (int child : adj.get(curr)) {
            if (visited[child]) {
                return true;
            }
            if (!visited[child] && dfs(child, visited, adj, vis)) {
                return true;
            }
        }
        visited[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>() {{

        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(2);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(4);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(1);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(0);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(3);
        }});

        isCyclic(6, arrayLists);
    }
}
