public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    private class Node {
        int val;
        int index;
        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.val - b.val;
        }
    }
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        List<Node> items = new ArrayList<Node>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            items.add(new Node(sum, i));
        }
        Collections.sort(items, new NodeComparator());
        int closet = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < items.size(); i++) {
            Node node = items.get(i);
            if (Math.abs(node.val) < Math.abs(closet)) {
                closet = Math.abs(node.val);
                index1 = 0;
                index2 = node.index;
            }
            if (i > 0) {
                Node prevNode = items.get(i - 1);
                if (Math.abs(node.val - prevNode.val) < Math.abs(closet)) {
                    closet = Math.abs(node.val - prevNode.val);
                    index1 = Math.min(node.index, prevNode.index) + 1;
                    index2 = Math.max(node.index, prevNode.index);
                }
            }
        }
        rst.add(index1);
        rst.add(index2);
        return rst;
    }
}

