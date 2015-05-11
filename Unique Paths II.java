public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int[][] a = obstacleGrid;
        if (a == null || a.length == 0) {
            return 0;
        }
        int row = a.length;
        int col = a[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (a[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j< col; j++) {
            if (a[0][j] == 1) {
                dp[0][j] = 0;
                break;
            } else {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
