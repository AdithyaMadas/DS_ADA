package graphs;

import java.util.*;

public class SmallestNumberOfNeighbours {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {


        int[][] matrix = new int[n][n];
        for (int[] i : matrix) {
            Arrays.fill(i, 10000);
        }

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] =  edge[2];
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (j == k || i == k || i == j) {
                        continue;
                    }
                    if (!(matrix[i][k] == -1) && !(matrix[k][j] == -1) && (matrix[i][j] == -1 || matrix[i][k] + matrix[k][j] < matrix[i][j])) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currReach = 0;
            for (int k : matrix[i]) {
                if (k != 10000 && k <= distanceThreshold) {
                    currReach++;
                }
            }
            if (min > currReach) {
                min = currReach;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
    }
}
