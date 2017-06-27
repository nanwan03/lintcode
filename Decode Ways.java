public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[]{1, 1, 1};
        for (int i = 1; i < s.length(); ++i) {
            dp[2] = 0;
            if (s.charAt(i) != '0') {
                dp[2] = dp[1];
            }
            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            if (10 <= val && val <= 26) {
                dp[2] += dp[0];
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}