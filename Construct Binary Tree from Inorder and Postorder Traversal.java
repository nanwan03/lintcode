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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildBST(inorder, 0, inorder.length - 1,
                        postorder, 0, postorder.length - 1);
    }
    private TreeNode buildBST(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        int k = findK(inorder, inStart, inEnd, postorder[poEnd]);
        if (k == - 1) {
            return null;
        }
        int leftLength = k - inStart;
        int rightLength = inEnd - k;
        TreeNode root = new TreeNode(inorder[k]);
        root.left = buildBST(inorder, inStart, k - 1, postorder, poStart, poStart + leftLength - 1);
        root.right = buildBST(inorder, k + 1, inEnd, postorder, poEnd - rightLength, poEnd - 1);
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
