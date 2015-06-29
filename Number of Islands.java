public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    rst++;
                    mark(grid, i, j);
                }
            }
        }
        return rst;
    }
    private void mark(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == false) {
        	return;
        }
        grid[i][j] = false;
        mark(grid, i + 1, j);
        mark(grid, i - 1, j);
        mark(grid, i, j + 1);
        mark(grid, i, j - 1);
    }
}
