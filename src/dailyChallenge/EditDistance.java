package dailyChallenge;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        return findDistance(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private static int findDistance(String word1, String word2, int index1, int index2) {
        if (index1 == -1) {
            return index2 + 1;
        }
        if (index2 == -1) {
            return index1 + 1;
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return findDistance(word1, word2, index1 - 1, index2 - 1);
        } else {
            int insert = findDistance(word1, word2, index1, index2 - 1);
            int delete = findDistance(word1, word2, index1 - 1, index2);
            int replace = findDistance(word1, word2, index1 - 1, index2 - 1);
            return Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
