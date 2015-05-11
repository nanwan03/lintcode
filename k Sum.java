public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        int[][][] dp = new int[k + 1][A.length][target + 1];
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j <= target; j++) {
        		dp[0][i][j] = j == 0 ? 1 : 0;
        		for (int m = 1; m <= k; m++) {
        			if (i > 0) {
        				dp[m][i][j] = dp[m][i - 1][j];
        				if (j >= A[i]) {
        					dp[m][i][j] += dp[m - 1][i - 1][j - A[i]];
        				}
        			} else if (m == 1) {
        				dp[m][i][j] = A[i] == j ? 1 : 0;
        			}
        		}
        	}
        }
        return dp[k][A.length - 1][target];
    }
}

