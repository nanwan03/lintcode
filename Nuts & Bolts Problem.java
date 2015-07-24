/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        quickSort(nuts, bolts, 0, nuts.length - 1, compare);
    }
    private void quickSort(String[] nuts, String[] bolts, int left, int right, NBComparator  compare) {
        if (left < right) {
            //Random r = new Random();
            //int pivot = r.nextInt(right - left + 1) + left;
            int pivot = partition(nuts, left, right, bolts[right], compare);
            partition(bolts, left, right, nuts[pivot], compare);
            quickSort(nuts, bolts, left, pivot - 1, compare);
            quickSort(nuts, bolts, pivot + 1, right, compare);
        }
  }
  private int partition(String[] arr, int left, int right, String pivot, NBComparator compare) {
        for (int i = left; i < right; ) {
            if (compare.cmp(arr[i], pivot) == -1 ||  // Smaller.
                (compare.cmp(arr[i], pivot) == 2 &&
                 compare.cmp(pivot, arr[i]) == 1)) {
                swap(arr, left++, i++);
            } else if (compare.cmp(arr[i], pivot) == 1 ||  // Bigger.
                      (compare.cmp(arr[i], pivot) == 2 &&
                       compare.cmp(pivot, arr[i]) == -1)) {
                ++i;
            } else {  // Equal.
                swap(arr, i, right);
            }
        }
        // Put the pivot to the partition index.
        swap(arr, left, right);

        // Return the partition index of an array.
        return left;
  }
  private void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
  }
};
