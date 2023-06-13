package graphs;

import java.util.*;

public class NoOfDistinctIslands {

    static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "{" + i + "," + j +
                    '}';
        }
    }
    static int countDistinctIslands(int[][] grid) {
        Set<List<Pair>> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    set.add(constructString(grid, i, j, 0, 0, new ArrayList<>()));
                }
            }
        }
        return set.size();
    }

    private static List<Pair> constructString(int[][] grid, int i, int j, int reli, int relj, List<Pair> strings) {
        strings.add(new Pair(reli, relj));
        grid[i][j] = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == 1) {
                constructString(grid, newI, newJ, reli + dir[0], relj + dir[1], strings);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));

    }
}
