public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int indexA = 0;
        int indexB = 0;
        int minDiff = Integer.MAX_VALUE;;
        while (indexA != A.length && indexB != B.length) {
            minDiff = Math.min(minDiff, Math.abs(A[indexA] - B[indexB]));
            if (A[indexA] <= B[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return minDiff;
    }
}

