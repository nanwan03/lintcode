public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = A.length / 2 - 1; i >= 0; --i) {
            adjust(A, i);
        }
    }
    private void adjust(int[] A, int i) {
        int size = A.length;
        while (i < size / 2) {
            int min = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < size && A[left] < A[min]) {
                min = left;
            }
            if (right < size && A[right] < A[min]) {
                min = right;
            }
            if (i == min) {
                return;
            }
            swap(A, i, min);
            i = min;
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}