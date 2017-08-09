public class Solution {
    /**
     * @param n an integer
     * @return how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Write your code here
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int end = 2; end <= n; ++end) {
            for (int start = end - 1; start >= 1; --start) {
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k < end; ++k) {
                    dp[start][end] = Math.min(dp[start][end], Math.max(dp[start][k - 1], dp[k + 1][end]) + k);
                }
            }
        }
        return dp[1][n];
    }
}