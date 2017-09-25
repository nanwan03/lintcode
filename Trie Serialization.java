/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */


class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Iterator iter = root.children.entrySet().iterator(); 
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            Character key = entry.getKey(); 
            TrieNode child = entry.getValue();
            sb.append(key);
            sb.append(serialize(child));
        }
        sb.append(">");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        Stack<TrieNode> stack = new Stack<TrieNode>();
        for (Character c : data.toCharArray()) {
            if (c == '<') {
                stack.push(cur);
            } else if (c == '>') {
                stack.pop();
            } else {
                cur = new TrieNode();
                stack.peek().children.put(c, cur);
            }
        }
        return root;
    }
}
