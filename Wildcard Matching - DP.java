public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return s == null;
        }
        int sSize = s.length();
        int pSize = p.length();
        s = " " + s;
        p = " " + p;
        boolean[] dp = new boolean[sSize + 1];
        dp[0] = true;
        boolean[] allstars = new boolean[pSize + 1];
        for (int i = 1; i <= pSize; ++i) {
            if (p.charAt(i) != '*') {
                break;
            }
            allstars[i] = true;
        }
        for (int i = 1; i <= pSize; ++i) {
            boolean pre = dp[0];
            dp[0] = allstars[i];
            for (int j = 1; j <= sSize; ++j) {
                boolean temp = dp[j];
                if (p.charAt(i) != '*') {
                    dp[j] = pre && (s.charAt(j) == p.charAt(i) || p.charAt(i) == '?');
                } else {
                    dp[j] = dp[j - 1] || dp[j];  //dp[i][j - 1] || dp[i - 1][j]
                }
                pre = temp;               //pre: dp[i - 1][j - 1]
            }
        }
        return dp[sSize];
     }
}