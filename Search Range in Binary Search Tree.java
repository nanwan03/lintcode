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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        helper(rst, root, k1, k2);
        return rst;
    }
    private void helper(List<Integer> rst, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (k1 < root.val) {
            helper(rst, root.left, k1, k2);
        }
        if (k1 <= root.val && root.val <= k2) {
            rst.add(root.val);
        }
        if (root.val < k2) {
            helper(rst, root.right, k1, k2);
        }
    }
}
