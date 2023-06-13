package graphs;

import java.util.*;

public class WordLadder2 {

    static class StringList{
        List<String> strings;
        Set<String> visited;

        public void addToList(String s) {
            strings.add(s);
            visited.add(s);
        }

        public StringList(List<String> s) {
            strings = new ArrayList<>();
            visited = new HashSet<>();
            strings.addAll(s);
            visited.addAll(s);
        }
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
                map.computeIfAbsent(pattern, (var) -> new ArrayList<>()).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Queue<StringList> queue = new LinkedList<>();
        boolean found = false;
//        Set<String> visited = new HashSet<>();
        queue.add(new StringList(Collections.singletonList(beginWord)));
        while (!found && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                StringList poll = queue.poll();
                List<String> stringList = poll.strings;
                String s = stringList.get(stringList.size() - 1);
                if (s.equalsIgnoreCase(endWord)) {
                    res.add(new ArrayList<>(stringList));
                    found = true;
                }
                for (int i = 0; i < s.length(); i++) {
                    String pattern = s.substring(0, i) + "*" + s.substring(i + 1);
                    for (String similar : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!poll.visited.contains(similar)) {
//                            queue.add(strings);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders("hit", "cog", strings));
    }
}
