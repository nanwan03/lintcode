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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, root, target);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        items.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            rst.add(new ArrayList<Integer>(items));
        } else {
            helper(rst, items, root.left, sum);
            helper(rst, items, root.right, sum);
        }
        items.remove(items.size() - 1);
    }
}