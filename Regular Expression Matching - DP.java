public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
	public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLength; i++) {
        	for (int j = 1; j <= pLength; j++) {
        		if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
        			dp[i][j] = dp[i - 1][j - 1];
        		} else if (p.charAt(j - 1) == '*') {
        			if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
        				dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        			}
        			dp[i][j] = dp[i][j] || dp[i][j - 2];
        		}
        	}
        }
        return dp[sLength][pLength];
    }
}
