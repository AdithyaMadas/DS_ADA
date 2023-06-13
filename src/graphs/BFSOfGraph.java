package graphs;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> res = new ArrayList<>();
        traverse(adj, queue, visited, res);
        return res;
    }

    private static void traverse(ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue, int[] visited, ArrayList<Integer> res) {
        if (queue.isEmpty()) {
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer poll = queue.poll();
            if (visited[poll] == 1) {
                continue;
            }
            visited[poll] = 1;
            res.add(poll);
            queue.addAll(adj.get(poll));
        }
        traverse(adj, queue, visited, res);
    }

    public static void main(String[] args) {

    }
}
