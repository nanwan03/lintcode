/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    private class ResultType {
        int notSteal;
        int steal;
        ResultType(int notSteal, int steal) {
            this.notSteal = notSteal;
            this.steal = steal;
        }
    }
    public int houseRobber3(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        ResultType rs = helper(root);
        return Math.max(rs.notSteal, rs.steal);
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int notSteal = Math.max(left.notSteal, left.steal) + Math.max(right.notSteal, right.steal);
        int steal = left.notSteal + right.notSteal + root.val;
        return new ResultType(notSteal, steal);
    }
}