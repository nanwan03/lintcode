public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    private class UF {
        int[] root;
        int count;
        UF(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; ++i) {
                root[i] = i;
            }
        }
        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        public void connect(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootX] = rootY;
                this.count--;
            }
        }
        public int query() {
            return this.count;
        }
        public void setCount(int count) {
            this.count = count;
        }
    }
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UF uf = new UF(row * col);
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        uf.setCount(count);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j]) {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col || !grid[nx][ny]) {
                            continue;
                        }
                        uf.connect(i * col + j, nx * col + ny);
                    }
                }
            }
        }
        return uf.query();
    }
}