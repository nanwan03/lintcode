public class Solution {
    static class segmentTreeNode {
        int start, end, count;
        segmentTreeNode left, right;
        segmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            this.count = 0;
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        // write your code here
        List<Integer> rst = new ArrayList<Integer>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);

        }
        if (min < 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= min;//deal with negative numbers, seems a dummy way
            }
        }
        for (int i : nums) {
            max = Math.max(max, i);
        }
        segmentTreeNode root = build(0, max);
        for (int i = nums.length - 1; i >= 0; --i) {
            rst.add(query(root, 0, nums[i] - 1));
            update(root, nums[i]);
        }
        Collections.reverse(rst);
        return rst;
    }
    public static segmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        segmentTreeNode root = new segmentTreeNode(start, end);
        if (start == end) {
            return root;
        }
        int mid = (start + end) >>> 1;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }

    public static int query(segmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.count;
        }
        int mid = (root.start + root.end) >>> 1;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start >= mid + 1) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }

    public static void update(segmentTreeNode root, int value) {
        if (root == null) {
            return;
        }
        root.count++;
        int mid = (root.start + root.end) >>> 1;
        if (value <= mid) {
            update(root.left, value);
        } else {
            update(root.right, value);
        }
    }
}