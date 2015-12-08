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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if (root == null) {
          return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          if (node == null) {
            hasNull = true;
          } else if (hasNull) {
            return false;
          } else {
            queue.offer(node.left);
            queue.offer(node.right);
          }
        }
        return true;
    }
}