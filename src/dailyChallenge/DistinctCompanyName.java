package dailyChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistinctCompanyName {
    public static long distinctNames(String[] ideas) {
        HashSet<Integer>[] charSets = new HashSet[26];
        long res = 0;
        for (int i = 0; i < 26; i++) {
            charSets[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            charSets[idea.charAt(0) - 'a'].add(idea.substring(1).hashCode());
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                long r1 = 0, r2 = 0;
                for (int q : charSets[i]) {
                    if (!charSets[j].contains(q)) {
                        r1++;
                    }
                }
                for (int q : charSets[j]) {
                    if (!charSets[i].contains(q)) {
                        r2++;
                    }
                }
                res += r1 * r2;
            }
        }
        return res * 2;
    }

    /*public static long distinctNames(String[] ideas) {
        long ans = 0;
        Set<String> strings = new HashSet<>();
        for (String i : ideas) {
            strings.add(i);
        }
        for (int i = 0; i < ideas.length; i++) {
            for (int j = 0; j < ideas.length; j++) {
                if (i == j) {
                    continue;
                }
                if (!strings.contains(ideas[j].substring(0, 1) + ideas[i].substring(1)) &&
                        !strings.contains(ideas[i].substring(0, 1) + ideas[j].substring(1))) {
                    ans++;
                }
            }
        }
        return ans;
    }*/

    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"coffee", "donuts", "time", "toffee","doffee"}));
        System.out.println(distinctNames(new String[]{"aa", "bb", "dd", "cc"}));
        System.out.println(distinctNames(new String[]{"lack","back"}));
    }
}
