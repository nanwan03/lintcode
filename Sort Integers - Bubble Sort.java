public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = 0; i < A.length; ++i) {
            for (int j = 1; j < A.length - i; ++j) {
                if (A[j - 1] > A[j]) {
                    swap(A, j, j - 1);
                }
            }
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}