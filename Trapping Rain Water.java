public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rst = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, A[left]);
            rightMax = Math.max(rightMax, A[right]);
            if (leftMax < rightMax) {
                rst += Math.max(0, leftMax - A[left]);
                left++;
            } else {
                rst += Math.max(0, rightMax - A[right]);
                right--;
            }
        }
        return rst;
    }
}
