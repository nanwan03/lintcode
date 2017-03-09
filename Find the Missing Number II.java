public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
     public int findMissing2(int n, String str) {
        // Write your code here
        boolean[] isused = new boolean[n + 1];
        return helper(0, n, str, isused);
    }
    private int helper(int index, int n, String str, boolean[] isused) {
        if (index >= str.length()) {
            for (int i = 1; i <= n; i++) {
                if (!isused[i]) {
                    return i;
                }
            }
            return -1;
        }
        int sum = str.charAt(index) - '0';
        if (sum == 0) {
            return -1;
        }
        
        for (int i = index + 1; i <= str.length() && sum <= n; ++i){
            if (!isused[sum]) {
                isused[sum] = true;
                int rst = helper(i, n, str, isused);
                if (rst != -1) {
                	return rst;
                }
                isused[sum] = false;
            }
            if (i < str.length()) {
            	sum = sum * 10 + (str.charAt(i) - '0');
            }
        }
        return -1;
    }
}