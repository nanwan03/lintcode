public class Solution {
	/**
	 * @param k: An integer
	 * @param prices: Given an integer array
	 * @return: Maximum profit
	 */
	public int maxProfit(int k, int[] prices) {
	    if (prices == null || prices.length == 0) {
	    	return 0;
	    }
	    if (k >= prices.length / 2) {
	    	return quickSolve(prices);
	    }
	    int[][] dp = new int[k + 1][prices.length];
	    for (int i = 1; i <= k; i++) {
	    	int temp = -prices[0];
	    	for (int j = 1; j < prices.length; j++) {
	    		dp[i][j] = Math.max(dp[i][j - 1], temp + prices[j]);
	    		temp = Math.max(temp, dp[i - 1][j - 1] - prices[j]);
	    	}
	    }
	    return dp[k][prices.length - 1];
	}
	private int quickSolve(int[] prices) {
		int rst = 0;
		for (int i = 1; i < prices.length; i++) {
			rst += Math.max(0,  prices[i] - prices[i - 1]);
		}
		return rst;
	}
}