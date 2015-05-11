import java.util.*;
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < A.length; i++) {
            TreeNode node = new TreeNode(A[i]);
            while (!stack.isEmpty() && A[i] > stack.peek().val) {
                TreeNode temp = stack.pop();
                if (node.left == null) {
                    node.left = temp;
                } else {
                    temp.right = node.left;
                    node.left = temp;
                }
            }
            stack.push(node);
        }
        TreeNode node = stack.pop();
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            prev = node;
            node = stack.pop();
            node.right = prev;
        }
        return node;
    }
}
