/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    private int rst = 1;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        helper(root);
        return rst;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        left = root.left != null && root.left.val == root.val + 1 ? left + 1 : 1;
        right = root.right != null && root.right.val == root.val + 1 ? right + 1 : 1;
        rst = Math.max(rst, Math.max(left, right));
        return Math.max(left, right);
    }
}