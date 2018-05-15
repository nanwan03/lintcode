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
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        helper(rst, root);
        return rst;
    }
    private int helper(List<List<Integer>> list, TreeNode root){
        if (root == null) {
            return -1;
        }
        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int level = Math.max(left, right) + 1;
     
        if (list.size() <= level) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        return level;
    }
}