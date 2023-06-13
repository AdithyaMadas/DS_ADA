package graphs;

import java.util.Arrays;

public class FloydWarshalls {
    public static void shortest_distance(int[][] matrix) {
        // k -> via
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
    }

    public static void main(String[] args) {
        int[][] ints = {{0, 1, 43}, {1, 0, 6}, {-1, -1, 0}};
        shortest_distance(ints);
        System.out.println(Arrays.deepToString(ints));
    }
}
