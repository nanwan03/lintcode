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
    private static class ResultType {
        int maxPath;
        int maxUp;
        int maxDown;
        ResultType(int maxPath, int maxUp, int maxDown) {
            this.maxPath = maxPath;
            this.maxUp = maxUp;
            this.maxDown = maxDown;
        }
    }
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        return helper(root).maxPath;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int down = 0;
        int up = 0;
        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(down, left.maxDown + 1);
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            up = Math.max(up, left.maxUp + 1);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(down, right.maxDown + 1);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            up = Math.max(up, right.maxUp + 1);
        }
        int len = down + 1 + up;
        len = Math.max(len, Math.max(left.maxPath, right.maxPath));
        return new ResultType(len, up, down);
    }
}