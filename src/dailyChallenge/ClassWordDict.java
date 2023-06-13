package dailyChallenge;

public class ClassWordDict {

    static class WordDictionary {

        class LetterNode {
            LetterNode[] next = new LetterNode[26];
            boolean isEnd;

        }

        LetterNode root;
        public WordDictionary() {
            root = new LetterNode();
        }

        public void addWord(String word) {
            LetterNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new LetterNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(LetterNode l, String word, int index) {
            if (word.length() == index) {
                return l.isEnd;
            }
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(index);
                if (c != '.') {
                    if (l.next[c - 'a'] != null) {
                        LetterNode letterNode = l.next[c - 'a'];
                        return search(letterNode, word, index + 1);
                    } else {
                        return false;
                    }
                } else {
                    for (int q = 0; q < 26; q++) {
                        if (l.next[q] != null && search(l.next[q], word, index + 1)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

}
