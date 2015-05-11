import java.util.*;

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

