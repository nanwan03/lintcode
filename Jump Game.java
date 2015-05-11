public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
	 public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int maxCover = 0;
        for (int i = 0; i <= maxCover && i < A.length; i++) {
            maxCover = Math.max(maxCover, i + A[i]);
        }
        return maxCover >= A.length - 1;
    }
}

