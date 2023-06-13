package codingRounds;

import slidingWindowAndTwoPointer.redo.LongestSubstringwithoutRepeating;

import java.util.*;

public class ProcessLogs {

    static class User {

        String userId;
        long signIn;

        public User(String userId, long signIn) {
            this.userId = userId;
            this.signIn = signIn;
        }
    }

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        HashMap<String, Long> users = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String i : logs) {
            String[] s = i.split(" ");
            if (s[2].equalsIgnoreCase("sign-in")) {
                users.put(s[0], Long.parseLong(s[1]));
            } else {
                if (Long.parseLong(s[1]) - users.get(s[0]) <= maxSpan) {
                    res.add(s[0]);
                }
            }
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });
        return res;
    }

    public static void main(String[] args) {
        System.out.println(processLogs(new ArrayList<String>() {{
            add("99 1 sign-in");
            add("100 10 sign-in");
            add("50 20 sign-in");
            add("100 15 sign-out");
            add("50 26 sign-out");
            add("99 2 sign-out");
        }}, 5));
    }
}
