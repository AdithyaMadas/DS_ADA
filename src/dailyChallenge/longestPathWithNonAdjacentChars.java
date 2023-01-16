package dailyChallenge;

import java.util.*;

public class longestPathWithNonAdjacentChars {
    static int res;
    static boolean[] visited;

    public static int longestPath(int[] parent, String s) {
        res = 1;
        visited = new boolean[s.length()];
        Arrays.fill(visited, false);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            ArrayList<Integer> children = map.getOrDefault(parent[i], new ArrayList<>());
            children.add(i);
            map.put(parent[i], children);

            children = map.getOrDefault(i, new ArrayList<>());
            children.add(parent[i]);
            map.put(i, children);
        }
        dfs(map, s, 0);
        return res;
    }

    private static int dfs(Map<Integer, ArrayList<Integer>> map, String s, int currNode) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        visited[currNode] = true;
        for (int i : map.getOrDefault(currNode, new ArrayList<>())) {
            if (!visited[i]) {
                int maxLen = dfs(map, s, i);
                if (s.charAt(i) != s.charAt(currNode)) {
                    queue.offer(-maxLen);
                }
            }
        }
        int longest = queue.isEmpty() ? 0 : -queue.poll();
        int secondLongest = queue.isEmpty() ? 0 : -queue.poll();

        res = Math.max(res, secondLongest + longest + 1);
        return longest + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPath(new int[]{-1}, "z"));
    }
}
