public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        int[] dp = new int[]{k, k * k, 0};
        if (n <= 2) {
            return dp[n - 1];
        }
        for (int i = 3; i <= n; ++i) {
            dp[2] = (k - 1) * (dp[0] + dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}