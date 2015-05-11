public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= A[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], V[i - 1] + dp[i - 1][j - A[i - 1]]);
                    }
                }
            }
        }
        return dp[A.length][m];
    }
}
