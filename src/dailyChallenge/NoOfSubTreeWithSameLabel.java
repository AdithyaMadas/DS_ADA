package dailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoOfSubTreeWithSameLabel {
    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Character> letterMap = new HashMap<>();
        for (int i = 0; i < labels.length(); i++) {
            letterMap.put(i, labels.charAt(i));
        }
        Map<Integer, ArrayList<Integer>> edgesMap = new HashMap<>();
        for (int[] i : edges) {
            ArrayList<Integer> edgeList = edgesMap.getOrDefault(i[0], new ArrayList<>());
            edgeList.add(i[1]);
            edgesMap.put(i[0], edgeList);
            edgeList = edgesMap.getOrDefault(i[1], new ArrayList<>());
            edgeList.add(i[0]);
            edgesMap.put(i[1], edgeList);
        }
        int[] toReturn = new int[n];
        getSum(toReturn, edgesMap, letterMap, 0, 0, labels);
        return toReturn;
    }

    private static Map<Character, Integer> getSum(int[] toReturn, Map<Integer, ArrayList<Integer>> edgesMap, Map<Integer, Character> letterMap, int toCheckNode, int parentNode, String labels) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i : edgesMap.get(toCheckNode)) {
            if (i == parentNode) {
                continue;
            }
            Map<Character, Integer> childMap = getSum(toReturn, edgesMap, letterMap, i, toCheckNode, labels);
            for (Map.Entry<Character, Integer> characterIntegerEntry : childMap.entrySet()) {
                map.put(characterIntegerEntry.getKey(), map.getOrDefault(characterIntegerEntry.getKey(), 0) + characterIntegerEntry.getValue());
            }
        }
        map.put(labels.charAt(toCheckNode), map.getOrDefault(labels.charAt(toCheckNode), 0) + 1);
        toReturn[toCheckNode] = map.get(labels.charAt(toCheckNode));
        return map;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd")));
    }
}
