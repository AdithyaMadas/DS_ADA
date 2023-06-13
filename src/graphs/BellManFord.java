package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] min = new int[V];
        Arrays.fill(min, 100000000);
        min[S] = 0;

        for (int i = 1; i < V; i++) {
            for (ArrayList<Integer> edge : edges) {
                if (min[edge.get(0)] == Integer.MAX_VALUE) {
                    continue;
                }
                if (min[edge.get(0)] + edge.get(2) < min[edge.get(1)]) {
                    min[edge.get(1)] = min[edge.get(0)] + edge.get(2);
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {
            if (min[edge.get(0)] == Integer.MAX_VALUE) {
                continue;
            }
            if (min[edge.get(0)] + edge.get(2) < min[edge.get(1)]) {
                return new int[]{-1};
            }
        }

        return min;
    }

    public static void main(String[] args) {

    }
}
