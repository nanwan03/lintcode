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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, root);
        return rst;
    }
    private void helper(List<String> rst, List<Integer> items, TreeNode root) {
        if (root == null) {
        	return;
        }
        items.add(root.val);
        if (root.left == null && root.right == null) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(items.get(0));
        	for (int i = 1; i < items.size(); ++i) {
        		sb.append("->").append(items.get(i));
        	}
        	rst.add(sb.toString());
        }
        helper(rst, items, root.left);
        helper(rst, items, root.right);
        items.remove(items.size() - 1);
    }
}
