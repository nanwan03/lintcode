public class Solution {
    /*
     * @param : an array of arrays
     * @return: the sum of all unique weighted paths
     */
    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	int row = grid.length;
    	int col = grid[0].length;
    	Set<Integer>[][] dp = new HashSet[row][col];
    	for (int i = 0; i < row; ++i) {
    	    for (int j = 0; j < col; ++j) {
    	        dp[i][j] = new HashSet<Integer>();
    	    }
    	}
    	int sum = 0;
    	for (int i = 0; i < row; ++i) {
    		sum += grid[i][0];
    		dp[i][0].add(sum);
    	}
    	sum = 0;
    	for (int j = 0; j < col; ++j) {
    		sum += grid[0][j];
    		dp[0][j].add(sum);
    	}
    	for (int i = 1; i < row; ++i) {
    		for (int j = 1; j < col; ++j) {
    			for (int num : dp[i - 1][j]) {
    				dp[i][j].add(num + grid[i][j]);
    			}
    			for (int num : dp[i][j - 1]) {
    				dp[i][j].add(num + grid[i][j]);
    			}
    		}
    	}
    	int rst = 0;
    	for (int num : dp[row - 1][col - 1]) {
    		rst += num;
    	}
    	return rst;
    }
};