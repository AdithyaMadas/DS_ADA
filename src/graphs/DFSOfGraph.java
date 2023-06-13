package graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DFSOfGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(adj, 0, new HashSet<Integer>(), res);
        return res;
    }

    private void traverse(ArrayList<ArrayList<Integer>> adj, int curr, HashSet<Integer> visited, ArrayList<Integer> res) {
        if (visited.contains(curr)) {
            return;
        }
        res.add(curr);
        visited.add(curr);
        for (int i : adj.get(curr)) {
            traverse(adj, i, visited, res);
        }
    }

    public static void main(String[] args) {

    }
}
