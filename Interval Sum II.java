public class Solution {
    /* you may need to use some attributes here */
    

    /**
     * @param A: An integer array
     */
    private class SegTree {
         public int start;
         public int end;
         public long sum;
         
         public SegTree left;
         public SegTree right;
         
         public SegTree(int start, int end) {
             this.start = start;
             this.end = end;
             this.left = null;
             this.right = null;
         }
         
         public SegTree(int start, int end, long sum) {
             this.start = start;
             this.end = end;
             this.sum = sum;
             this.left = null;
             this.right = null;
         }
     }
    private SegTree root;
    public Solution(int[] A) {
        // write your code here
        root = buildSegTree(A, 0, A.length - 1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return getSum(root, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        modify(root, index, value);
    }
    
    private SegTree buildSegTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegTree(start, end, A[start]);
        }
        int mid = (start + end) / 2;
        SegTree root = new SegTree(start, end);
        root.left = buildSegTree(A, start, mid);
        root.right = buildSegTree(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    private long getSum(SegTree root, int start, int end) {
        if (root == null || start > end) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return getSum(root.left, start, end);
        } else if (start >= mid + 1) {
            return getSum(root.right, start, end);
        } else {
            return getSum(root.left, start, mid) + getSum(root.right, mid + 1, end);
        }
    }
    private void modify(SegTree root, int index, int value) {
        if (root == null) {
            return;
        }
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }
}

