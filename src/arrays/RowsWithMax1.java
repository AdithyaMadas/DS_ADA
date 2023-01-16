package arrays;

public class RowsWithMax1 {

    static int rowWithMax1s(int arr[][], int n, int m) {
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (arr[i][j] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(rowWithMax1s(new int[][]{{0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}}, 4, 4));
    }
}
