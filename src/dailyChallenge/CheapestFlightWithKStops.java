package dailyChallenge;

import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class CheapestFlightWithKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }

//    static class DestPrice{
//        int dest, price;
//
//        public DestPrice(int dest, int price) {
//            this.dest = dest;
//            this.price = price;
//        }
//    }
//
//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Map<Integer, List<DestPrice>> map = new HashMap<>();
//        for (int[] i : flights) {
//            map.computeIfAbsent(i[0], val -> new ArrayList<>()).add(new DestPrice(i[1], i[2]));
//        }
//        return getPrice(map, src, dst, k, 0, new HashSet<>());
//    }
//
//    private static int getPrice(Map<Integer, List<DestPrice>> map, int src, int dst, int k, int currPrice, Set<Integer> visitedNodes) {
//        if (k < 0) {
//            return -1;
//        }
//        visitedNodes.add(src);
//        List<DestPrice> destPrices = map.getOrDefault(src, new ArrayList<>());
//        int min = Integer.MAX_VALUE;
//        for (DestPrice i : destPrices) {
//            if (i.dest == dst) {
//                int price = currPrice + i.price;
//                if (price < min) {
//                    min = price;
//                }
//            } else if (!visitedNodes.contains(i.dest)) {
//                int price = getPrice(map, i.dest, dst, k - 1, currPrice + i.price, visitedNodes);
//                if (price < min && price != -1) {
//                    min = price;
//                }
//            }
//            visitedNodes.add(i.dest);
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {0, 2, 500}}, 0, 2, 0));

    }
}
