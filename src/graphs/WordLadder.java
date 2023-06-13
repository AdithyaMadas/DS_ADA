package graphs;

import java.util.*;

public class WordLadder {

    //bidirectional BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
                map.computeIfAbsent(pattern, (var) -> new ArrayList<>()).add(s);
            }
        }
        int steps = 1;
        Queue<String> queue1 = new LinkedList<>();
        queue1.add(beginWord);
        Queue<String> queue2 = new LinkedList<>();
        queue2.add(endWord);
        HashMap<String, Integer> visitedQueue1 = new HashMap<>();
        HashMap<String, Integer> visitedQueue2 = new HashMap<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size = queue1.size();
            while (size-- > 0) {
                String s = queue1.poll();
                if (visitedQueue2.containsKey(s)) {
                    return steps + visitedQueue2.get(s);
                }
                for (int i = 0; i < s.length(); i++) {
                    String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
                    for (String similar : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visitedQueue1.containsKey(similar)) {
                            visitedQueue1.put(similar, steps);
                            queue1.add(similar);
                        }
                    }
                }
            }
            size = queue2.size();
            while (size-- > 0) {
                String s = queue2.poll();
                if (visitedQueue1.containsKey(s)) {
                    return steps + visitedQueue1.get(s);
                }
                for (int i = 0; i < s.length(); i++) {
                    String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
                    for (String similar : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visitedQueue2.containsKey(similar)) {
                            visitedQueue2.put(similar, steps);
                            queue2.add(similar);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }

//    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String s : wordList) {
//            for (int i = 0; i < s.length(); i++) {
//                String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
//                map.computeIfAbsent(pattern, (var) -> new ArrayList<>()).add(s);
//            }
//        }
//        int steps = 1;
//        Queue<String> queue = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        queue.add(beginWord);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                String s = queue.poll();
//                if (s.equalsIgnoreCase(endWord)) {
//                    return steps;
//                }
//                for (int i = 0; i < s.length(); i++) {
//                    String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
//                    for (String similar : map.getOrDefault(pattern, new ArrayList<>())) {
//                        if (!visited.contains(similar)) {
//                            visited.add(similar);
//                            queue.add(similar);
//                        }
//                    }
//                }
//            }
//            steps++;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", strings));
        System.out.println(ladderLength("hit", "ere", strings));
    }
}
