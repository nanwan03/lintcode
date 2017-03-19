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
        for (int i = 1; i < A.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (A[j] < A[j - 1]) {
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