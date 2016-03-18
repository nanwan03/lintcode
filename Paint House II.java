public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int min1 = 0, min2 = 0, idMin1 = -1;
    
        for(int i = 0; i < m; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, idm1 = -1;
    
            for(int j = 0; j < n; j++) {
                // If same color as j - 1, we can only extend from 2nd min of j - 1
                int cost = costs[i][j] + (j == idMin1 ? min2 : min1);
    
                // Update m1 m2 if cost is smaller than any of them
                if(cost < m1) {               
                    m2 = m1; m1 = cost; idm1 = j;
                } else if(cost < m2) {        
                    m2 = cost;
                }
            }
            min1 = m1; idMin1 = idm1; min2 = m2; 
        }
        return min1;   
    }
}