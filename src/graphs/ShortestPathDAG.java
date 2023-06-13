package graphs;

import java.util.*;

public class ShortestPathDAG {

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<Edge>[] edgeList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int[] i : edges) {
            edgeList[i[0]].add(new Edge(i[1], i[2]));
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, edgeList, stack, visited);
            }
        }
        while (stack.peek() != 0) {
            stack.pop();
        }

        int[] min = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            for (Edge i : edgeList[pop]) {
                min[i.to] = Math.min(min[i.to], min[pop] + i.weight);
            }
        }

        for (int i = 0; i < N; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                min[i] = -1;
            }
        }
        return min;
    }

    private static void dfs(int curr, ArrayList<Edge>[] edgeList, Stack<Integer> stack, boolean[] visited) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (Edge i : edgeList[curr]) {
            dfs(i.to, edgeList, stack, visited);
        }
        stack.add(curr);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPath(6, 7, new int[][]{{0, 1, 2}, {0, 4, 1}, {4, 5, 4}
                , {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}})));

    }
}
