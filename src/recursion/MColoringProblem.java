package recursion;

import java.util.Arrays;

public class MColoringProblem {
    public static boolean graphColoring(boolean graph[][], int m, int n) {
        return generate(graph, m, n, 0, new int[n]);
    }

    private static boolean generate(boolean[][] graph, int noColors, int n, int currNode, int[] nodeColors) {
        if (currNode == n) {
            return true;
        }
        for (int i = 1; i <= noColors; i++) {
            nodeColors[currNode] = i;
            if (isPossible(graph, nodeColors, currNode, n)) {
                if (generate(graph, noColors, n, currNode + 1, nodeColors)) {
                    return true;
                }
            }
            nodeColors[currNode] = 0;
        }
        return false;
    }

    private static boolean isPossible(boolean[][] graph, int[] nodeColors, int currNode, int n) {
        int currColor = nodeColors[currNode];
        for (int i = 0; i < n; i++) {
            if (graph[currNode][i] && nodeColors[currNode] == nodeColors[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(graphColoring(new boolean[][]
                        {{false, true, true, true}, {true, false, true, false}, {true, true, false, true}, {true, false, true, false}}
                , 3, 4));

    }
}
