package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    static int findCircleNum(int[][] adj) {
        int numberOfProvinces = 0;
        Set<Integer> set = new HashSet<>(adj.length);
        for (int i = 0; i < adj.length; i++) {
            if (!set.contains(i)) {
                isProvince(adj, set, i);
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }

    private static void isProvince(int[][] adj, Set<Integer> set, int index) {
        int[] arrayList = adj[index];
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == 1 && i != index) {
                if (!set.contains(i)) {
                    set.add(i);
                    isProvince(adj, set, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
