public class Solution {
    /*
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */
    private static class TrieNode {
        TreeMap<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
        boolean isEnd = false;
        public TrieNode() {
            
        }
    }
    private TrieNode root = new TrieNode();
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return rst;
        }
        for (String str : words) {
            insert(str);
        }
        int[] dp = new int[target.length() + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = i;
        }
        helper(root, rst, k, target, dp, new StringBuilder());
        return rst;
    }
    private void insert(String str) {
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    private void helper(TrieNode cur, List<String> rst, int k, String target, int[] dp, StringBuilder sb) {
        int size = target.length();
        if (cur.isEnd && dp[size] <= k) {
            rst.add(sb.toString());
        }
        int[] next = new int[size + 1];
        for (char c = 'a'; c <= 'z'; ++c) {
            if (cur.children.containsKey(c)) {
                next[0] = dp[0] + 1;
                for (int i = 1; i <= target.length(); ++i) {
                    if (target.charAt(i - 1) == c) {
                        next[i] = Math.min(dp[i - 1], Math.min(next[i - 1] + 1, dp[i] + 1));
                    } else {
                        next[i] = Math.min(dp[i - 1] + 1, Math.min(next[i - 1] + 1, dp[i] + 1));
                    }
                }
                sb.append(c);
                helper(cur.children.get(c), rst, k, target, next, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}