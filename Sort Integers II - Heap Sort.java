public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
          return;
        }
        int size = A.length;
        for (int i = size / 2 - 1; i >= 0; --i) {
          adjust(A, i, size);
        }
        for (int i = size - 1; i >= 0; --i) {
          swap(A, 0, i);
          size--;
          adjust(A, 0, size);
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
      private void adjust(int[] array, int i, int size) {
        while (i < size / 2) {
          int max = i;
          int left = i * 2 + 1;
          int right = i * 2 + 2;
          if (left < size && array[left] > array[max]) {
            max = left;
          }
          if (right < size && array[right] > array[max]) {
            max = right;
          }
          if (max == i) {
            return;
          }
          swap(array, i, max);
          i = max;
        }
      }
}