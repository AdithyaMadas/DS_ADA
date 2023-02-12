package dailyChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClosestToTwoNodes {
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> map1 = new HashMap();
        getAllElementsPossible(map1, edges, node1, 0);
        HashMap<Integer, Integer> map2 = new HashMap();
        getAllElementsPossible(map2, edges, node2, 0);
        int currMaxDis = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (!map1.containsKey(i) || !map2.containsKey(i)) {
                continue;
            }
            int distance = Math.max(map1.get(i), map2.get(i));
            if (currMaxDis > distance) {
                currMaxDis = distance;
                ans = i;
            } else if (currMaxDis == distance) {
                if (i < ans) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    private static void getAllElementsPossible(HashMap<Integer, Integer> map, int[] edges, int node, int distance) {
        if (node == -1 || map.containsKey(node)) {
            return;
        }
        map.put(node, distance);
        getAllElementsPossible(map, edges, edges[node], distance + 1);
    }

    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
    }
}
