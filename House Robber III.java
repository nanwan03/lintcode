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
    //helper[i][0]表示以i为根的子树不偷根节点能获得的最高价值，helper[i][1]表示以i为根的子树偷根节点能获得的最高价值
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }
    private int[] helper(TreeNode root) {
        if (root == null) {
            int[] now = new int[]{0, 0};
            return now;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] now = new int[2];
        now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        now[1] = left[0] + right[0] + root.val;
        return now;
    }
}