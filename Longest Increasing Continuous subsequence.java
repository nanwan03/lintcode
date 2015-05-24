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
        int tempLongest = 1;
        for (int i = 0; i < A.length - 1; i ++) {
          if (A[i] < A[i + 1]) {
            tempLongest++;
            longest = Math.max(longest, tempLongest);
          } else {
            tempLongest = 1;
          }
        }
        tempLongest = 1;
        for (int i = A.length - 2; i >= 0; i --) {
          if (A[i] > A[i + 1]) {
            tempLongest++;
            longest = Math.max(longest, tempLongest);
          } else {
            tempLongest = 1;
          }
        }
        return longest;
    }
}
