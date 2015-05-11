class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int tail = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexA >= 0 && indexB >= 0) {
            A[tail--] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
        }
        while (indexA >= 0) {
            A[tail--] = A[indexA--];
        }
        while (indexB >= 0) {
            A[tail--] = B[indexB--];
        }
    }
}
