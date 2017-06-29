public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        int sSize = s.length();
        int pSize = p.length();
        boolean[][] dp = new boolean[sSize + 1][pSize + 1];
        dp[0][0] = true;
        s = " " + s;
        p = " " + p;
        for (int i = 2; i <= pSize; ++i) {
            if (p.charAt(i) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= sSize; ++i) {
            for (int j = 1; j <= pSize; ++j) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (j > 1 && p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[sSize][pSize];
    }
}