public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private class Node {
        Node[] next;
        boolean end;
        Node() {
            next = new Node[26];
            end = false;
        }
        public void insert(String str) {
            Node node = this;
            for (int i = 0; i < str.length(); i++) {
                if(node.next[str.charAt(i) - 'a'] == null) {
                    node.next[str.charAt(i) - 'a'] = new Node();
                }
                node = node.next[str.charAt(i) - 'a'];
            }
            node.end = true;
        }
    }
    public boolean wordSegmentation(String s, Set<String> dict) {
        // write your code here   
        if (s == null || s.length() == 0) {
            return true;
        }
        Node node = new Node();
        boolean[] dp = new boolean[s.length()];
        for (String str : dict) {
            node.insert(str);
        }
        findMatch(dp, s, 0, node);
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                findMatch(dp, s, i + 1, node);
            }
        }
        return dp[s.length() - 1];
    }
    private void findMatch(boolean[] dp, String str, int pos, Node node) {
        for (int i = pos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
                if (node.end) {
                    dp[i] = true;
                }
            } else {
                break;
            }
        }
    }
}
