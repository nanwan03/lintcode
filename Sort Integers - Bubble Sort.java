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
            int min = i;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            swap(A, i, min);
        }
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}