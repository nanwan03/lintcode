public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        long maxPrev = Math.max(A[0], A[1]);
        long max2Before = A[0];
        for (int i = 2; i < A.length; i++) {
            long tempMax = Math.max(max2Before + A[i], maxPrev);
            max2Before = maxPrev;
            maxPrev = tempMax;
        }
        return maxPrev;
    }
}
