public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
          return 0;
        }
        int longest = 1;
        int tempIncrease = 1;
        int tempDecrease = 1;
        for (int i = 0; i < A.length - 1; i ++) {
          if (A[i] < A[i + 1]) {
            tempIncrease++;
            tempDecrease = 1;
            longest = Math.max(longest, tempIncrease);
          } else {
            tempDecrease++;
            tempIncrease = 1;
            longest = Math.max(longest, tempDecrease);
          }
        }
        return longest;
    }
}
