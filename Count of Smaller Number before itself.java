public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */
    class SegmentTreeNode {
         public int start, end;
         public int count;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.count = 0;
        }
    }
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int min = 10000;
        int max = 0;
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        SegmentTreeNode root = buildTree(min, max);
        for (int i : A) {
            modify(root, i);
            rst.add(query(root, i));
        }
        return rst;
    }
    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = buildTree(start, (start + end ) / 2);
        root.right = buildTree((start + end) / 2 + 1, end);
        return root;
    }
    private void modify(SegmentTreeNode root, int value) {
        if (root == null) {
            return;
        }
        if (root.start == value && root.end == value) {
            root.count++;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (value <= mid) {
            modify(root.left, value);
        } else if (value >= mid + 1) {
            modify(root.right, value);
        }
        root.count++;
    }
    private int query(SegmentTreeNode root, int value) {
        if (root == null) {
            return 0;
        }
        if (root.start == value && root.end == value) {
            return 0;
        }
        int mid = (root.start + root.end) / 2;
        if (value <= mid) {
            return query(root.left, value);
        } else if (value >= mid + 1) {
            return root.left.count + query(root.right, value);
        }
        return -1;
    }
}

