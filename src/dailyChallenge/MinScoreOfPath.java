package dailyChallenge;

import java.util.*;

public class MinScoreOfPath {

    public static int minScore(int n, int[][] roads) {
        HashMap<Integer, ArrayList<int[]>> edgeList = new HashMap<>();
        HashMap<Integer, Integer> min = new HashMap<>();
        for (int[] i : roads) {
            edgeList.computeIfAbsent(i[0], (v) -> new ArrayList<int[]>()).add(new int[]{i[1], i[2]});
            edgeList.computeIfAbsent(i[1], (v) -> new ArrayList<int[]>()).add(new int[]{i[0], i[2]});

            if (min.containsKey(i[0])) {
                Integer integer = min.get(i[0]);
                min.put(i[0], Math.min(integer, i[2]));
            } else {
                min.put(i[0], i[2]);
            }

            if (min.containsKey(i[1])) {
                Integer integer = min.get(i[1]);
                min.put(i[1], Math.min(integer, i[2]));
            } else {
                min.put(i[1], i[2]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] vis = new boolean[n];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (vis[poll - 1]) {
                continue;
            }
            vis[poll - 1] = true;
            for (int[] edge : edgeList.getOrDefault(poll, new ArrayList<>())) {
                queue.offer(edge[0]);
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                minVal = Math.min(minVal, min.get(i + 1));
            }
        }
        return minVal;
    }
    public static void main(String[] args) {
        System.out.println(minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }
}
