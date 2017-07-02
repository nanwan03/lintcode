public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        int sSize = s.length();
        int pSize = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[sSize + 1][pSize + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pSize; ++i) {
            if (p.charAt(i) != '*') {
                break;
            }
            dp[0][i] = true;
        }
        for (int i = 1; i <= sSize; ++i) {
            for (int j = 1; j <= pSize; ++j) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[sSize][pSize];
     }
}