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
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return root;
        }
        if (minimum <= root.val && root.val <= maximum) {
            root.left = trimBST(root.left, minimum, root.val);
            root.right = trimBST(root.right, root.val, maximum);
            return root;
        } else if (root.val < minimum) {
            return trimBST(root.right, minimum, maximum);
        } else {
            return trimBST(root.left, minimum, maximum);
        }
    }
}