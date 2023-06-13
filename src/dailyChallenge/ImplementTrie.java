package dailyChallenge;

public class ImplementTrie {

    class TrieLetter {
        TrieLetter[] child = new TrieLetter[26];
        boolean isWord;

        public TrieLetter() {
        }

        public TrieLetter(TrieLetter[] child) {
            this.child = child;
        }
    }
    class Trie {

        TrieLetter root;

        public Trie() {
            root = new TrieLetter();
        }

        public void insert(String word) {
            TrieLetter letter = root;
            for (char c : word.toCharArray()) {
                if (letter.child[c - 'a'] == null) {
                    letter.child[c - 'a'] = new TrieLetter();
                }
                letter = letter.child[c - 'a'];
            }
            letter.isWord = true;
        }

        public boolean search(String word) {
            TrieLetter letter = root;
            for (char c : word.toCharArray()) {
                if (letter.child[c - 'a'] == null) {
                    return false;
                }
                letter = letter.child[c - 'a'];
            }
            return letter.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieLetter letter = root;
            for (char c : prefix.toCharArray()) {
                if (letter.child[c - 'a'] == null) {
                    return false;
                }
                letter = letter.child[c - 'a'];
            }
            return true;
        }
    }
}
