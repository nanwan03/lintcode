public class Solution {
    /*
     * @param : a 2d boolean array
     * @param : an integer
     * @return: the number of Islands
     */
    private class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int rst = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == true) {
                    if (mark(grid, i, j, row, col) >= k) {
                        rst++;
                    }
                }
            }
        }
        return rst;
    }
    private int mark(boolean[][] grid, int x, int y, int row, int col) {
        int rst = 0;
        grid[x][y] = false;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            rst++;
            List<Node> neighbors = getNeighbor(grid, node.x, node.y, row, col);
            for (Node n : neighbors) {
                queue.offer(n);
            }
        }
        return rst;
    }
    private List<Node> getNeighbor(boolean[][] grid, int x, int y, int row, int col) {
        List<Node> rst = new ArrayList<Node>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] == false) {
                continue;
            }
            rst.add(new Node(nx, ny));
            grid[nx][ny] = false;
        }
        return rst;
    }
};