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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    private Stack<TreeNode> stack;
    private TreeNode cur;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        cur = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty() || cur != null;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node;
    }
}
