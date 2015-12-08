/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        boolean isNext = false;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (isNext) {
                    return cur;
                }
                if (cur == p) {
                    isNext = true;
                }
                cur = cur.right;
            }
        }
        return cur;
    }
}