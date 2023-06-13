package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestWeightedPath {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] min = new int[V];
        Arrays.fill(min, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        min[S] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (ArrayList<Integer> edges : adj.get(poll)) {
                if (min[edges.get(0)] > min[poll] + edges.get(1)) {
                    min[edges.get(0)] = min[poll] + edges.get(1);
                    queue.offer(edges.get(0));
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> arrayLists1 = new ArrayList<ArrayList<ArrayList<Integer>>>() {{
            add(new ArrayList<ArrayList<Integer>>() {{
                add(new ArrayList<Integer>() {{
                    add(1);
                    add(9);
                }});
            }});


            add(new ArrayList<ArrayList<Integer>>() {{
                add(new ArrayList<Integer>() {{
                    add(0);
                    add(9);
                }});
            }});
        }};

        System.out.println(Arrays.toString(dijkstra(2, arrayLists1, 0)));
    }
}
