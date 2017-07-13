public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] aux = new int[A.length];
        return mergeSort(A, aux, 0, A.length - 1);
    }
    private long mergeSort(int[] A, int[] aux, int start, int end) {
        if (start >= end) {
            return 0;
        }
        long rst = 0;
        int mid = start + (end - start) / 2;
        rst += mergeSort(A, aux, start, mid);
        rst += mergeSort(A, aux, mid + 1, end);
        rst += merge(A, aux, start, mid, end);
        return rst;
    }
    private void copyOf(int[] src, int[] des, int start, int end) {
        for (int i = start; i <= end; ++i) {
            des[i] = src[i];
        }
    }
    private long merge(int[] A, int[] aux, int start, int mid, int end) {
        if (start >= end) {
            return 0;
        }
        copyOf(A, aux, start, end);
        int leftIndex = start;
        int rightIndex = mid + 1;
        int cur = start;
        long rst = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (aux[leftIndex] <= aux[rightIndex]) {
                A[cur++] = aux[leftIndex++];
            } else {
                rst += mid + 1 - leftIndex;
                A[cur++] = aux[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            A[cur++] = aux[leftIndex++];
        }
        return rst;
    }
}