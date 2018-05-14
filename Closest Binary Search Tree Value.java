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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int rst = Integer.MAX_VALUE;
        if (target < root.val) {
            rst = closestValue(root.left, target); 
        } else {
            rst = closestValue(root.right, target);
        }
        return Math.abs(root.val - target) < Math.abs(rst - target) ? root.val : rst;
    }
}