public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * MLE
     */
    private class Node {
        int value;
        int x;
        int y;
        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.value - b.value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix.length < matrix[0].length) {
            return hSearch(matrix, k);
        } else {
            return vSearch(matrix, k);
        }
    }
    private int hSearch(int[][] matrix, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
        for (int i = 0; i < Math.min(matrix.length, k); ++i) {
            heap.offer(new Node(matrix[i][0], i, 0));
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
            Node n = heap.poll();
            rst = n.value;
            int x = n.x;
            int y = n.y;
            if (y + 1 < matrix[0].length) {
                heap.offer(new Node(matrix[x][y + 1], x, y + 1));
            }
            
        }
        return rst;
    }
    private int vSearch(int[][] matrix, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
        for (int i = 0; i < Math.min(matrix[0].length, k); ++i) {
            heap.offer(new Node(matrix[0][i], 0, i));
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
            Node n = heap.poll();
            rst = n.value;
            int x = n.x;
            int y = n.y;
            if (x + 1 < matrix.length) {
                heap.offer(new Node(matrix[x + 1][y], x + 1, y));
            }
        }
        return rst;
    }
}
