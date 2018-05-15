public class Solution {
    /**
     * @param n: an integer
     * @return: the number of solutions
     */
    public int threeSum2(int n) {
        // Write your code here
        int m = (int)Math.round(Math.sqrt(n));
        if (m * m > n) {
            m--;
        }
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            int res = n - i * i;
            int left = i, right = m;
            while (left <= right) {
                int tmp = left * left + right * right;
                if (tmp > res) {
                    right--;
                } else if (tmp < res) {
                    left++;
                } else {
                    ans++;
                    left++;
                }
            }
        }
        return ans;
    }
}