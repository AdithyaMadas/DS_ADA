package dailyChallenge;

public class AlienSorted {

    static Integer[] rank = new Integer[26];

    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isGreater(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGreater(String word, String word1) {
        for (int i = 0; i < word.length() && i<word1.length(); i++) {
            if (rank[word.charAt(i) - 'a'] > rank[word1.charAt(i) - 'a']) {
                return false;
            } else if (rank[word.charAt(i) - 'a'] < rank[word1.charAt(i) - 'a']) {
                return true;
            }
            if (word.length() > word1.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"kuvp", "q"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
