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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode rootNode = new DoublyListNode(root.val);
        if (root.left == null && root.right == null) {
            return rootNode;
        }
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right);
        rootNode.next = right;
        if (right != null) {
            right.prev = rootNode;
        }
        if (left != null) {
            DoublyListNode dummy = left;
            while (left.next != null) {
                left = left.next;
            }
            left.next = rootNode;
            rootNode.prev = left;
            return dummy;
        } else {
            return rootNode;
        }
    }
}
