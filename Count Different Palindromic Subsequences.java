public class Solution {
    /**
     * @param str: a string S
     * @return: the number of different non-empty palindromic subsequences in S
     */
    private static final int MOD = 1000000007;
    public int countPalindSubseq(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }
        TreeSet<Integer>[] set = new TreeSet[26];
        for (int i = 0; i < set.length; ++i) {
            set[i] = new TreeSet<Integer>();
        }
        for (int i = 0; i < str.length(); ++i) {
            set[str.charAt(i) - 'a'].add(i);
        }
        Integer[][] dp = new Integer[str.length() + 1][str.length() + 1];
        return helper(str, set, dp, 0, str.length());
    }
    private int helper(String S, TreeSet<Integer>[] set, Integer[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        long rst = 0;
        for (int i = 0; i < 26; ++i) {
            Integer newStart = set[i].ceiling(start);
            Integer newEnd = set[i].lower(end);
            if (newStart == null || newStart >= end) {
                continue;
            }
            rst++;
            if (newStart != newEnd) {
                rst++;
            }
            rst += helper(S, set, dp, newStart + 1, newEnd);
        }
        dp[start][end] = (int)(rst % MOD);
        return dp[start][end];
    }
}