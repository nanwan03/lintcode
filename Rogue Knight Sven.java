public class Solution {
    /**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // Write your code here
        long[][] dp = new long[n + 1][m + 1];
    	dp[0][m] = 1;
    	for (int i = 1; i <= n; ++i) {
    		for (int j = Math.max(0, i - limit); j < i; ++j) {
    			for (int k = cost[i]; k <= m; ++k) {
    				dp[i][k - cost[i]] += dp[j][k];
    			}
    		}
    	}
    	long sum = 0;
    	for (int i = 0; i <= m; ++i) {
    		sum += dp[n][i];
    	}
    	return sum;
    }
}