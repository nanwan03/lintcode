/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        int length1 = getLength(A);
        int length2 = getLength(B);
        
        int diff = Math.abs(length1 - length2);
        while (diff != 0) {
          if (length1 > length2) {
            A = A.parent;
          } else {
            B = B.parent;
          }
          diff--;
        }
        while (A != null && B != null && A != B) {
          A = A.parent;
          B = B.parent;
        }
        return A;
    }
    private int getLength(ParentTreeNode node) {
        int length = 0;
        while (node != null) {
          node = node.parent;
          length++;
        }
        return length;
    }
}
