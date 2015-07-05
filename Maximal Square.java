public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
          return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int rst = 0;
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
            if (matrix[i][j] == 1) {
              if (i == 0 || j == 0) {
                dp[i][j] = 1;
              } else {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
              }
              rst = Math.max(rst, dp[i][j]);
            }
          }
        }
        return rst * rst;
    }
}
