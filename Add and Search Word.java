import java.util.*;

class TrieNode {
    TrieNode[] next;
    boolean end;
    // Initialize your data structure here.
    public TrieNode() {
        next = new TrieNode[26];
        end = false;
    }
}

public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode node = root;
    	for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return search(word, 0, root);
    }
    private boolean search(String word, int wordIndex, TrieNode node) {
    	if (node == null) {
    		return false;
    	}
    	if (wordIndex == word.length()) {
    		return node.end;
    	}
    	if (word.charAt(wordIndex) == '.') {
    		for (TrieNode next : node.next) {
    			if (next != null) {
	    			boolean flag = search(word, wordIndex + 1, next);
	    			if (flag) {
	    				return true;
	    			}
    			}
    		}
    	} else {
    		if (node.next[word.charAt(wordIndex) - 'a'] != null) {
    			return search(word, wordIndex + 1, node.next[word.charAt(wordIndex) - 'a']);
    		}
    	}
    	return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
