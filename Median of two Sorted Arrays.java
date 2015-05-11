class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int length = A.length + B.length;
        if (length % 2 == 0) {
            return (double)(findK(A, 0, B, 0, length / 2) + findK(A, 0, B, 0, length / 2 + 1)) / 2.0;
        } else {
            return findK(A, 0, B, 0, length / 2 + 1);
        }
    }
    private double findK(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int keyA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (keyA < keyB) {
            return findK(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findK(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}

