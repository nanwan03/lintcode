public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        if (n <= 1) {
            return n;
        }
        Set<Integer> squareSet = buildSet(n); // This set contains all perfect square numbers (1, 4, 9, 16, ...) <= n 
        int[] dp = new int[n + 1]; // dp[i] means the least number of perfect suqare numbers sum to n.
        for (int i = 1; i <= n; i++) {
            if (squareSet.contains(i)) { // If this number is a perfect square number
                dp[i] = 1; // Set itself to 1
            }
            for (int j: squareSet) { // For each perfect square number j, "the least number for i + j" will be "the number for i" + 1.
                if (i + j > n) {
                    break;
                } else { 
                    dp[i + j] = dp[i + j] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + j]); // choose the smaller one if it isn't 0.
                }
            }
        }
        return dp[n];
    }
    
    private Set<Integer> buildSet(int n) { // Build the set of perfect square number
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 1; i * i <= n; i++) {
            set.add(i * i);
        }
        return set;
    }
}