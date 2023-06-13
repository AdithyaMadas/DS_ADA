package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionary {
    public static String findOrder(String [] dict, int N, int K) {
        ArrayList<Integer>[] arrayLists = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < dict.length - 1; i++) {
            insertToMap(arrayLists, dict[i], dict[i + 1]);
        }
        StringBuilder stringBuilder = new StringBuilder();

        boolean[] visited = new boolean[K];
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                populateString(stringBuilder, visited, i, arrayLists);
            }
        }
        return stringBuilder.reverse().toString();
    }

    private static void populateString(StringBuilder stringBuilder, boolean[] visited, int curr, ArrayList<Integer>[] arrayLists) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (int child : arrayLists[curr]) {
            populateString(stringBuilder, visited, child, arrayLists);
        }
        stringBuilder.append((char) (curr + 'a'));
    }

    private static void insertToMap(ArrayList<Integer>[] arrayLists, String s, String greaterWord) {
        for (int i = 0; i < s.length() && i < greaterWord.length(); i++) {
            if (s.charAt(i) != greaterWord.charAt(i)) {
                arrayLists[s.charAt(i) - 'a'].add(greaterWord.charAt(i) - 'a');
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}, 5, 4));
        System.out.println(findOrder(new String[]{"caa", "aaa", "aab"}, 3, 3));
    }
}
