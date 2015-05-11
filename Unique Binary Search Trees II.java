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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
         return generate(1, n);
    }
    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
        if (left > right) {
            rst.add(null);
            return rst;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftL = generate(left, i - 1);
            List<TreeNode> rightL = generate(i + 1, right);
            for (TreeNode l : leftL) {
                for (TreeNode r : rightL) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
}
