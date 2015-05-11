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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
     private class ResultType {
         int singlePath;
         int maxPath;
         ResultType(int singlePath, int maxPath) {
             this.singlePath = singlePath;
             this.maxPath = maxPath;
         }
     }
     private ResultType helper(TreeNode root) {
         if (root == null) {
             return new ResultType(0, Integer.MIN_VALUE);
         }
         ResultType left = helper(root.left);
         ResultType right = helper(root.right);
         int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
         singlePath = Math.max(singlePath, 0);
         int maxPath = Math.max(left.maxPath, right.maxPath);
         maxPath = Math.max(maxPath, left.singlePath + root.val + right.singlePath);
         return new ResultType(singlePath, maxPath);
     }
    public int maxPathSum(TreeNode root) {
        // write your code here
        return  helper(root).maxPath;
    }
}
