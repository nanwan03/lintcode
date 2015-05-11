public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int pIndex = 0; pIndex < p.length(); pIndex++) {
            if (p.charAt(pIndex) != '*') {
                for (int sIndex = s.length() - 1; sIndex >= 0; sIndex--) {
                    dp[sIndex + 1] = dp[sIndex] && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?');
                }
            } else {
                int sIndex = 0;
                while (sIndex <= s.length() && !dp[sIndex]) {
                    sIndex++;
                }
                while (sIndex <= s.length()) {
                    dp[sIndex++] = true;
                }
            }
            dp[0] = dp[0] && (p.charAt(pIndex) == '*');
        }
        return dp[s.length()];
     }
}
