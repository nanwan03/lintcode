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
         public int min;
         
         public SegTree left;
         public SegTree right;
         
         public SegTree(int start, int end) {
             this.start = start;
             this.end = end;
             this.min = Integer.MAX_VALUE;
             this.left = null;
             this.right = null;
         }
         
         public SegTree(int start, int end, int min) {
             this.start = start;
             this.end = end;
             this.min = min;
             this.left = null;
             this.right = null;
         }
     }
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return null;
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        SegTree root = buildSegTree(A, 0, A.length - 1);
        for (Interval interval : queries) {
            rst.add(getMin(root, interval.start, interval.end));
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
        root.min = Math.min(root.left.min, root.right.min);
        return root;
    }
    private int getMin(SegTree root, int start, int end) {
        if (root == null || start > end) {
            return Integer.MAX_VALUE;
        }
        if (root.start == start && root.end == end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return getMin(root.left, start, end);
        } else if (start >= mid + 1) {
            return getMin(root.right, start, end);
        } else {
            return Math.min(getMin(root.left, start, mid), getMin(root.right, mid + 1, end));
        }
    }
}
