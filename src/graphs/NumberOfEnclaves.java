package graphs;

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    dfs(grid, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]
                {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}
        ));
    }
}
