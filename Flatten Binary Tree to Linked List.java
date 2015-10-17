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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode prevTail) {
        if (prevTail != null) {
            prevTail.left = null;
            prevTail.right = root;
        }
        prevTail = root;
        TreeNode right = root.right;
        if (root.left != null) {
            prevTail = flatten(root.left, prevTail);
        }
        if (right != null) {
            prevTail = flatten(right, prevTail);
        }
        return prevTail;
    }
}
