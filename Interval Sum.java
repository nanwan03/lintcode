/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
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
    public ArrayList<Long> intervalSum(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return null;
        }
        ArrayList<Long> rst = new ArrayList<Long>();
        SegTree root = buildSegTree(A, 0, A.length - 1);
        for (Interval interval : queries) {
            rst.add(getSum(root, interval.start, interval.end));
        }
        return rst;
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
}
