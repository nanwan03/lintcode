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
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    private int rst = 0;
    public int findTilt(TreeNode root) {
        // Write your code here
        helper(root);
        return rst;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        rst += Math.abs(left - right);
        return left + right + root.val;
    }
}