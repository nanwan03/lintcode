public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        return helper(n, str, new boolean[n + 1]);
    }
    private int helper(int n, String str, boolean[] isused) {
        if (str.length() == 0) {
            for (int i = 1; i <= n; ++i) {
                if (!isused[i]) {
                    return i;
                }
            }
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            sum = sum * 10 + (str.charAt(i) - '0');
            if (sum == 0 || sum > n) {
                break;
            }
            if (!isused[sum]) {
                isused[sum] = true;
                int rst = helper(n, str.substring(i + 1), isused);
                if (rst != -1) {
                    return rst;
                }
                isused[sum] = false;
            }
        }
        return -1;
    }
}