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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        if (value < root.val) {
            root.left = removeNode(root.left, value);
            return root;
        } else if (root.val < value) {
            root.right = removeNode(root.right, value);
            return root;
        } else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        } else {
            TreeNode smallest = getSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }
    }
    private TreeNode getSmallest(TreeNode node) {
        while (node.left.left != null) {
            node = node.left;
        }
        TreeNode smallest = node.left;
        node.left = node.left.right;
        return smallest;
    }
}
