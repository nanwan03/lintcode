public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];
        int rst = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (dp[i][j] == 0) {
                    rst = Math.max(rst, fill(A, i, j, Integer.MIN_VALUE, dp));
                }
            }
        }
        return rst;
    }
    private int fill(int[][] A, int i, int j, int prev, int[][] dp) {
        int row = A.length;
        int col = A[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || A[i][j] <= prev) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        dp[i][j] = Math.max(dp[i][j], 1 + fill(A, i + 1, j, A[i][j], dp));
        dp[i][j] = Math.max(dp[i][j], 1 + fill(A, i - 1, j, A[i][j], dp));
        dp[i][j] = Math.max(dp[i][j], 1 + fill(A, i, j + 1, A[i][j], dp));
        dp[i][j] = Math.max(dp[i][j], 1 + fill(A, i, j - 1, A[i][j], dp));
        return dp[i][j];
    }
}
