public class WordDictionary {
    private static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
        boolean isEnd = false;
        public TrieNode() {
            
        }
    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    private TrieNode root = new TrieNode();
    public void addWord(String word) {
        // write your code here
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return search(root, word, 0);
    }
    private boolean search(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode next : cur.children.values()) {
                if (search(next, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            return search(cur.children.get(c), word, index + 1);
        }
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");