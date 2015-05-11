import lintcode.util.TreeNode;

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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }
        return buildBST(inorder, 0, inorder.length - 1,
                        preorder, 0, preorder.length - 1);
    }
    private TreeNode buildBST(int[] inorder, int inStart, int inEnd,
                                int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int k = findK(inorder, inStart, inEnd, preorder[preStart]);
        if (k == -1) {
            return null;
        }
        int leftLength = k - inStart;
        int rightLength = inEnd - k;
        TreeNode root = new TreeNode(inorder[k]);
        root.left = buildBST(inorder, inStart, k - 1, preorder, preStart + 1, preStart + leftLength);
        root.right = buildBST(inorder, k + 1, inEnd, preorder, preEnd + 1 - rightLength, preEnd);
        return root;
    }
    private int findK(int[] A, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
