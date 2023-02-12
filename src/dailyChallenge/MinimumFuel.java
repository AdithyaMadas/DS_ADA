package dailyChallenge;

import java.util.*;

public class MinimumFuel {

    static long ans = 0, seats = 0;

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        ans = 0;
        MinimumFuel.seats = seats;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            children.get(road[0]).add(road[1]);
            children.get(road[1]).add(road[0]);
        }
        for (int i : children.get(0)) {
            fuelReq(i, children, 0);
        }
        return ans;
    }

    private static long fuelReq(int currNode, List<List<Integer>> children, int parent) {
        long currFuel = 1;
        List<Integer> list = children.get(currNode);
        for (int i : list) {
            if (i == parent) {
                continue;
            }
            currFuel += fuelReq(i, children, currNode);
        }
        ans += Math.ceil((double) currFuel / seats);
        return currFuel;
    }

    public static void main(String[] args) {
        System.out.println(minimumFuelCost(new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5));
        System.out.println(minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
        System.out.println(minimumFuelCost(new int[][]{}, 1));
    }
}
