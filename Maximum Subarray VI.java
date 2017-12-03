public class Solution {
    /*
     * @param : the array
     * @return: the max xor sum of the subarray in a given array
     */
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int value;
        TrieNode() {
            this.value = 0;
        }
    }
    private TrieNode root = new TrieNode();
    private static final int SIZE = 32;
    public int maxXorSubarray(int[] nums) {
        // write code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 0;
        int rst = 0;
        for (int i : nums) {
            prev ^= i;
            insert(prev);
            rst = Math.max(rst, query(prev));
        }
        return rst;
    }
    private void insert(int value) {
        TrieNode cur = root;
        for (int i = SIZE - 1; i >= 0; --i) {
            int idx = (value >> i) & 1;
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.value = value;
    }
    private int query(int value) {
        TrieNode cur = root;
        for (int i = SIZE - 1; i >= 0; --i) {
            int idx = (value >> i) & 1;
            if (cur.children[1 - idx] != null) {
                cur = cur.children[1 - idx];
            } else {
                cur = cur.children[idx];
            }
        }
        return value ^ cur.value;
    }
}