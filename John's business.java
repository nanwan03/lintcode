public class Solution {
    /**
     * @param A: The prices [i]
     * @param k: 
     * @return: The ans array
     */
    private static class Node {
        int start;
        int end;
        Node left;
        Node right;
        int min;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.min = Integer.MAX_VALUE;
        }
    }
    public int[] business(int[] A, int k) {
        // Write your code here
        if (A == null || A.length == 0) {
            return A;
        }
        Node root = buildTree(A, 0, A.length - 1);
        int[] rst = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            rst[i] = A[i] - query(root, Math.max(0, i - k), Math.min(A.length - 1, i + k));
        }
        return rst;
    }
    private Node buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(start, end);
        if (start == end) {
            node.min = A[start];
            return node;
        }
        int mid = (start + end) / 2;
        node.left = buildTree(A, start, mid);
        node.right = buildTree(A, mid + 1, end);
        node.min = Math.min(node.left.min, node.right.min);
        return node;
    }
    private int query(Node root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start >= mid + 1) {
            return query(root.right, start, end);
        } else {
            return Math.min(query(root.left, start, end), query(root.right, start, end));
        }
    }
}