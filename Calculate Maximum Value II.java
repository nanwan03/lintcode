public class Solution {
    /**
     * @param str: a string of numbers
     * @return: the maximum value
     */
    public int maxValue(String str) {
        // write your code here
    	if (str == null || str.length() == 0) {
    		return 0;
    	}
    	int size = str.length();
    	int[][] dp = new int[size + 1][size + 1];
    	for (int end = 1; end <= size; ++end) {
    		for (int start = end; start >= 1; --start) {
    			if (start == end) {
    				dp[start][end] = str.charAt(start - 1) - '0';
    			} else {
    				dp[start][end] = Integer.MIN_VALUE;
    				for (int k = end - 1; k >= start; --k) {
    					dp[start][end] = Math.max(dp[start][end], Math.max(dp[start][k] + dp[k + 1][end], dp[start][k] * dp[k + 1][end]));
    				}
    			}
    		}
    	}
    	return dp[1][size];
    }
}