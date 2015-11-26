public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] rst = new int[n][n];
        if (n == 0) {
            return rst;
        }
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int k = 1;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                rst[top][i] = k++;
            }
            for (int i = top; i < bottom; i++) {
                rst[i][right] = k++;
            }
            for (int i = right; i > left; i--) {
                rst[bottom][i] = k++;
            }
            for (int i = bottom; i > top; i--) {
                rst[i][left] = k++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 == 1) {
            rst[n / 2][n / 2] = k;
        }
        return rst;
    }
}
