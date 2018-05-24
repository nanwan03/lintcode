public class Solution {
    /**
     * @param grid: the grid
     * @return: the number of corner rectangles
     */
    public int countCornerRectangles(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < row; ++j) {
                int tmp = 0;
                for (int k = 0; k  < col; ++k) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        tmp++;
                    }
                }
                rst += (tmp - 1) * tmp / 2;
            }
        }
        return rst;
    }
}