package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            dfs(i, adj.get(i), vis, stack);
        }
        int[] ans = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int curr, ArrayList<Integer> list, boolean[] vis, Stack<Integer> stack) {
        if (vis[curr]) {
            return;
        }
        vis[curr] = true;
        for (int i : list) {
            dfs(i, list, vis, stack);
        }
        stack.add(curr);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topoSort(4, new ArrayList<>())));
    }
}
