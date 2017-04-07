public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */
    private class Node {
        int start;
        int end;
        int count;
        Node left;
        Node right;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
            this.count = 0;
        }
    }
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        Node root = buildTree(min, max);
        for (int i : A) {
            rst.add(query(root, min, i - 1));
            modify(root, i);
        }
        return rst;
    }
    private Node buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(start, end);
        }
        Node root = new Node(start, end);
        int mid = (start + end) / 2;
        root.left = buildTree(start, mid);
        root.right = buildTree(mid + 1, end);
        return root;
    }
    private void modify(Node root, int value) {
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
        } else {
            modify(root.right, value);
        }
        root.count = root.left.count + root.right.count;
    }
    private int query(Node root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start >= mid + 1) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
}
