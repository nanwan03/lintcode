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
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            String str = s.substring(i - 1, i + 1);
            int temp = Integer.valueOf(str);
            if (10 <= temp && temp <= 26) {
                dp[i] = dp[i] + (i == 1 ? 1 : dp[i - 2]);
            }
        }
        return dp[s.length() - 1];
    }
}