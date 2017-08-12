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
        for (int end = 1; end <= n; ++end) {
            for (int start = end; start >= 1; --start) {
                dp[start][end] = start == end ? 0 : Integer.MAX_VALUE;
                for (int k = end - 1; k >= start; --k) {
                    dp[start][end] = Math.min(dp[start][end], Math.max(dp[start][k - 1], dp[k + 1][end]) + k);
                }
            }
        }
        return dp[1][n];
    }
}