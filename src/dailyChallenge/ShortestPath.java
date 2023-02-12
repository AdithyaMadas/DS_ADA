package dailyChallenge;

import java.util.*;

public class ShortestPath {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // Two sets one for blu and another for red
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        // red edges in 0 - col
        for (int[] re : red_edges) {
            graph[0][ re[0] ].add(re[1]);
        }
        // blu edges in 1 - col
        for (int[] blu : blue_edges) {
            graph[1][ blu[0] ].add(blu[1]);
        }
        int[][] res = new int[2][n];
        // Zero edge is always accessible to itself - leave it as 0
        for (int i = 1; i < n; i++) {
            res[0][i] = 2 * n;
            res[1][i] = 2 * n;
        }
        // Q entries are vert with a color (up to that point)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); // either with red
        q.offer(new int[] {0, 1}); // or with blue
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int vert = cur[0];
            int colr = cur[1];
            // No need to keep track of level up to now
            // only need to keep what color - and the length
            // is automatically derived from previous node
            for (int nxt : graph[1 - colr][vert]) {
                if (res[1 - colr][nxt] == 2 * n) {
                    res[1 - colr][nxt] = 1 + res[colr][vert];
                    q.offer(new int[] {nxt, 1 - colr});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Math.min(res[0][i], res[1][i]);
            ans[i] = (t == 2 * n) ? -1 : t;
        }
        return ans;
    }

//    class Edges{
//        List<Integer> redList = new ArrayList<>();
//        List<Integer> blueList = new ArrayList<>();
//
//        public void addRed(int i) {
//            redList.add(i);
//        }
//
//        public void addBlue(int i) {
//            blueList.add(i);
//        }
//    }
//
//    class Color {
//        int node;
//        int color;
//
//        public Color(int node, int color) {
//            this.node = node;
//            this.color = color;
//        }
//    }
//    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        Edges[] edges = new Edges[n];
//        for (int i = 0; i < n; i++) {
//            edges[i] = new Edges();
//        }
//        for (int[] edge : redEdges) {
//            edges[edge[0]].addRed(edge[1]);
//        }
//        for (int[] edge : blueEdges) {
//            edges[edge[0]].addBlue(edge[1]);
//        }
//        int[] res = new int[n];
//        Arrays.fill(res, -1);
//        res[0] = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        int level = 0;
//        Set<Color> visited = new HashSet<>();
//        while (!queue.isEmpty()) {
//            level++;
//            Queue<Integer> queue1 = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                Integer poll = queue.poll();
//                if(visited.contains(new Color(poll, level & 1))) continue;
//                List<Integer> list = ((level & 1) == 1) ? edges[poll].blueList : edges[poll].redList;
//                for (int i : list) {
//                    if (i != poll) queue1.add(i);
//                    if (res[i] == -1) {
//                        visited.add(new Color(poll, level & 1));
//                        res[i] = level;
//                    }
//                }
//            }
//            queue = queue1;
//        }
//        queue.add(0);
//        level = 0;
//        visited = new HashSet<>();
//        while (!queue.isEmpty()) {
//            level++;
//            Queue<Integer> queue1 = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                Integer poll = queue.poll();
//                if(visited.contains(new Color(poll, level & 1))) continue;
//                List<Integer> list = ((level & 1) == 1) ? edges[poll].redList : edges[poll].blueList;
//                for (int i : list) {
//                    if (i != poll) queue1.add(i);
//                    if (res[i] == -1 || res[i] > level) {
//                        visited.add(new Color(poll, level & 1));
//                        res[i] = level;
//                    }
//                }
//            }
//            queue = queue1;
//        }
//        return res;
//    }
    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();

        System.out.println(Arrays.toString(shortestPath.shortestAlternatingPaths(3, new int[][]{{0, 1}, {0, 2}}, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(shortestPath.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{1, 2}})));
        System.out.println(Arrays.toString(shortestPath.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{2, 1}})));
    }
}
