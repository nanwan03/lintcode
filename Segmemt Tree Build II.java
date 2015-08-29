/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return build(A, 0, A.length - 1);
    }
    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        root.left = build(A, start, (start + end ) / 2);
        root.right = build(A, (start + end) / 2 + 1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
}
