package graphs;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) {
            return image;
        }
        image[sr][sc] = color;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int i = sr + direction[0];
            int j = sc + direction[1];
            if (i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == original) {
                floodFill(image, i, j, color);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }
}
