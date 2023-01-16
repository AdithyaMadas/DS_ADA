package dailyChallenge;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinTime {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, ArrayList<Integer>> mapChildren = new HashMap<>();
        for (int[] i : edges) {
            ArrayList<Integer> list = mapChildren.getOrDefault(i[0], new ArrayList<>());
            list.add(i[1]);
            mapChildren.put(i[0], list);
            list = mapChildren.getOrDefault(i[1], new ArrayList<>());
            list.add(i[0]);
            mapChildren.put(i[1], list);
        }
        int ans = getCostToFindChildren(mapChildren, hasApple, 0, 0);
        return ans > 0 ? ans - 2 : 0;
    }

    private static int getCostToFindChildren(HashMap<Integer, ArrayList<Integer>> mapChildren, List<Boolean> hasApple, int index, int parent) {
        int cost = 0;
        for (int i : mapChildren.get(index)) {
            if (i == parent) {
                continue;
            }
            cost += getCostToFindChildren(mapChildren, hasApple, i, index);
        }
        if (cost > 0) {
            return cost + 2;
        } else {
            return hasApple.get(index) ? 2 : 0;
        }
    }


    public static void main(String[] args) {
//        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, new ArrayList<Boolean>() {{
//            add(false);
//            add(false);
//            add(true);
//            add(false);
//            add(false);
//            add(true);
//            add(false);
//        }}));
        System.out.println(minTime(8, new int[][]{{0,1},{1,2},{2,3},{1,4},{2,5},{2,6},{4,7}}, new ArrayList<Boolean>() {{
            add(true);
            add(true);
            add(false);
            add(true);
            add(false);
            add(true);
            add(true);
            add(false);
        }}));
    }
}
