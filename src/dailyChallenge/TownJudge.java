package dailyChallenge;

public class TownJudge {
    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        for (int[] i : trust) {
            arr[i[0] - 1]--;
            arr[i[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}}));
    }
}
