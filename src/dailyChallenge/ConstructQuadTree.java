package dailyChallenge;

public class ConstructQuadTree {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public static Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    private static Node construct(int[][] grid, int starti, int endi, int startj, int endj) {
        if (allSame(grid, starti, startj, endi, endj)) {
            return new Node(grid[starti][startj] == 1, true);
        } else {
            Node head = new Node(false, false);
            head.topLeft = construct(grid, starti, (starti + endi) / 2, startj, (startj + endj) / 2);
            head.topRight = construct(grid, starti, (starti + endi) / 2, (startj + endj + 1) / 2, endj);
            head.bottomLeft = construct(grid, (starti + endi + 1) / 2, endi, startj, (startj + endj) / 2);
            head.bottomRight = construct(grid, (starti + endi + 1) / 2, endi, (startj + endj + 1) / 2, endj);
            return head;
        }
    }

    private static boolean allSame(int[][] grid, int starti, int startj, int endi, int endj) {
        int ele = grid[starti][startj];
        for (int i = starti; i <= endi; i++) {
            for (int j = startj; j <= endj; j++) {
                if (grid[i][j] != ele) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(construct(new int[][]
//                {{0, 1}, {1, 0}}
//        ));
        System.out.println(construct(new int[][]
                {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}}
        ));

    }
}
