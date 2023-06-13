package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_KahnsAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        System.out.println(adj);
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];
        for (ArrayList<Integer> edge : adj) {
            for (int i : edge) {
                inDegree[i]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[V];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[index++] = poll;
            for (int i : adj.get(poll)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>() {{
            add(2);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
//            add(2);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
//            add(2);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(0);
            add(2);
        }});

        arrayLists.add(new ArrayList<Integer>() {{
        }});

        topoSort(4, arrayLists);
    }
}
