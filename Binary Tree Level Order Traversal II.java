import java.util.ArrayList;
import lintcode.util.TreeNode;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> items = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                items.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rst.add(items);
        }
        Collections.reverse(rst);
        return rst;
    }
}
