public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        if (left == null || right == null) {
            TreeNode notNul = left == null ? right : left;
            if (notNul.val >= root.val) {
                return notNul;
            } else {
                return root;
            }
        } else {
            if (root.val >= left.val && root.val >= right.val) {
                return root;
            } else if (left.val >= root.val && left.val >= right.val) {
                return left;
            } else {
                return right;
            }
        }
    }
}