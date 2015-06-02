/**
 * public class Compare {
 *     public static int cmp(int a, int b);
 * }
 * You can use Compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @return: nothing
     */
    public void sortNutsAndBolts(int[] nuts, int[] bolts) {
        // write your code here
        quickSort(nuts, bolts, 0, nuts.length - 1);
    }
    private void quickSort(int[] nuts, int[] bolts, int left, int right) {
        if (left >= right) {
          return;
        }
        Random r = new Random();
        int pivot = r.nextInt(right - left + 1) + left;
        pivot = partition2(nuts, left, right, bolts[pivot]);
        partition2(bolts, left, right, nuts[pivot]);
        quickSort(nuts, bolts, left, pivot - 1);
        quickSort(nuts, bolts, pivot + 1, right);
  }
  private int partition(int[] array, int left, int right, int target) {
      for (int i = left; i < right;) {
          if (Compare.cmp(array[i], target) == -1 ||
                (Compare.cmp(array[i], target) == 2 && Compare.cmp(target, array[i]) == 1)) {
                swap(array, left++, i++);  
            } else if (Compare.cmp(array[i], target) == 1 ||
                (Compare.cmp(array[i], target) == 2 && Compare.cmp(target, array[i]) == -1)) {
                ++i;
            } else {
                swap(array, i, right);
            }
      }
      swap(array, left, right);
      return left;
        
  }
  private int partition2(int[] array, int left, int right, int target) {
      int cur = left;
      while (cur <= right) {
          if (Compare.cmp(array[cur], target) == -1 ||
                (Compare.cmp(array[cur], target) == 2 && Compare.cmp(target, array[cur]) == 1)) {
                    swap(array, left++, cur++);
            } else if (Compare.cmp(array[cur], target) == 1 ||
                (Compare.cmp(array[cur], target) == 2 && Compare.cmp(target, array[cur]) == -1)) {
                    swap(array, cur, right--);
            } else {
                cur++;
            } 
      }
      return left;
  }
  private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
  }
};
