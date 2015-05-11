public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    private class Node {
    int x;
    int y;
    int value;
    Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
  private class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.value - b.value;
    }
  }
    public int trapRainWater(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
          return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] level = new int[row][col];
        Queue<Node> heap = new PriorityQueue<Node>(row * col, new NodeComparator());
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
            if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
              level[i][j] = matrix[i][j];
              heap.offer(new Node(i, j, matrix[i][j]));
            } else {
              level[i][j] = Integer.MAX_VALUE;
            }
          }
        }
        while (!heap.isEmpty()) {
          Node node = heap.poll();
          List<Node> neighbors = getNeighbor(node, row, col, level);
          for (Node neighbor : neighbors) {
            int temp = neighbor.value;
            neighbor.value = Math.max(matrix[neighbor.x][neighbor.y], Math.min(level[neighbor.x][neighbor.y], level[node.x][node.y]));
            if (neighbor.value != temp) {
              heap.offer(neighbor);
              level[neighbor.x][neighbor.y] = neighbor.value;
            }
          }
        }
        int rst = 0;
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
            rst += Math.max(0, level[i][j] - matrix[i][j]);
          }
        }
        return rst;
    }
    private List<Node> getNeighbor(Node node, int row, int col, int[][] level) {
        int x = node.x;
        int y = node.y;
        List<Node> rst = new ArrayList<Node>();
        if (x - 1 > 0) {
          rst.add(new Node(x - 1, y, level[x - 1][y]));
        }
        if (x + 1 < row) {
          rst.add(new Node(x + 1, y, level[x + 1][y]));
        }
        if (y - 1 > 0) {
          rst.add(new Node(x, y - 1, level[x][y - 1]));
        }
        if (y + 1 < col) {
          rst.add(new Node(x, y + 1, level[x][y + 1]));
        }
        return rst;
    }
};
