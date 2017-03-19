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
        quickSort(A, 0, A.length - 1);
    }
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
          return;
        }
        Random r = new Random();
        int pivot = partition(array, left, right, r.nextInt(right - left + 1) + left);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }
    private int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        int cur = left;
        while (cur <= right) {
          if (array[cur] < pivotValue) {
            swap(array, left++, cur++);
          } else if (array[cur] == pivotValue) {
            cur++;
          } else {
            swap(array, cur, right--);
          }
        }
        return left;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}