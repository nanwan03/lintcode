public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int[][] dp = new int[2][105];
        int ptr = 0;
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < A.size(); i++) {
        	int cur = A.get(i);
        	int next = ptr ^ 1;
        	Arrays.fill(dp[next], Integer.MAX_VALUE);
        	for (int j = 1; j <= 100; j++) {
        		int diff = Math.abs(j - cur);
        		int rangeL = Math.max(1,  j - target);
        		int rangeR = Math.min(100, j + target);
        		for (int k = rangeL; k <= rangeR; k++) {
        			dp[next][j] = Math.min(dp[next][j], dp[ptr][k] + diff);
        		}
        	}
        	ptr = next;
        }
        int rst = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
        	rst = Math.min(rst, dp[ptr][i]);
        }
        return rst;
    }
}
