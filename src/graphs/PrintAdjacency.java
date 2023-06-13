package graphs;

import java.util.ArrayList;

public class PrintAdjacency {
    public static ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            adj.get(i).add(0, i);
        }
        return adj;
    }


    public static void main(String[] args) {

    }
}
