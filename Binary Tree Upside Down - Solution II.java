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
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode prev = null;
        TreeNode prevRight = null;
        while (root != null) {
            TreeNode next = root.left;
            TreeNode nextRight = root.right;
            root.left = prevRight;
            root.right = prev;
            prev = root;
            prevRight = nextRight;
            root = next;
        }
        return prev;
    }
}