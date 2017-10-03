public class Solution {
    /*
     * @param : the prices
     * @param : the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
        // Write your code here
    	if (n == 0) {
    		return 0;
    	}
    	int[] helper = new int[n + 1];
    	helper[0] = 0;
    	for (int i = 1; i <= n; ++i) {
    		helper[i] = prices[i - 1];
    	}
    	int[] dp = new int[n + 1];
    	dp[1] = helper[1];
    	for (int i = 2; i <= n; ++i) {
    		for (int j = 0; j < i; ++j) {
    			dp[i] = Math.max(dp[i], dp[j] + Math.max(helper[i - j], dp[i - j]));
    		}
    	}
    	return dp[n];
    }
}