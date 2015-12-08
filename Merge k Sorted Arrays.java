public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    class Node {
    int val;
    int x;
    int y;
    Node(int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }
  }
  class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.val - b.val;
    }
  }
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        int[][] a = arrays;
        if (a == null || a.length == 0) {
          return new ArrayList<Integer>();
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
        	for (int j = 0; j < a[i].length; j++) {
        		count++;
        	}
        }
        if (count == 0) {
          return new ArrayList<Integer>();
        }
        List<Integer> rst = new ArrayList<Integer>();
        int index = 0;
        Queue<Node> heap = new PriorityQueue<Node>(count, new NodeComparator());
        for (int i = 0; i < a.length; i++) {
          if (a[i].length > 0) {
            heap.offer(new Node(a[i][0], i, 0));
          }
        }
        while (!heap.isEmpty()) {
          Node node = heap.poll();
          int val = node.val;
          int x = node.x;
          int y = node.y;
          rst.add(val);
          if (y < a[x].length - 1) {
            heap.offer(new Node(a[x][y + 1], x, y + 1));
          }
        }
        return rst;
    }
}