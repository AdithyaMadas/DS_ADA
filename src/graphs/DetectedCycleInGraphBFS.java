package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectedCycleInGraphBFS {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i]) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int w = 0; w < size; w++) {
                    Integer poll = q.poll();
                    if(vis[poll]) return true;
                    vis[poll] = true;
                    for (int e : adj.get(poll)) {
                        if(!vis[e]) q.add(e);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>() {{
            add(1);
        }});
        list.add(new ArrayList<Integer>() {{
            add(0);
            add(2);
            add(4);
        }});
        list.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});
        list.add(new ArrayList<Integer>() {{
            add(2);
            add(4);
        }});
        list.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});

        System.out.println(isCycle(5, list));
    }
}
