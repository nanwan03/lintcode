public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
	public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int temp1 = 1;
        int temp2 = 2;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                temp1 += temp2;
            } else {
                temp2 += temp1;
            }
        }
        return (n % 2 == 1) ? temp1 : temp2;
    }
}
