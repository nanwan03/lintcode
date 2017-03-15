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
    private void quickSort(String[] nuts, String[] bolts, int left, int right, NBComparator compare) {
        if (left >= right) {
            return;
        }
        Random r = new Random();
        int p = partition(nuts, left, right, bolts[r.nextInt(right - left) + left], compare);
        partition(bolts, left, right, nuts[p], compare);
        quickSort(nuts, bolts, left, p - 1, compare);
        quickSort(nuts, bolts, p + 1, right, compare);
    }
    private int partition(String[] array, int left, int right, String pivotValue, NBComparator compare) {
        int cur = left;
        while (cur <= right) {
            if (compare.cmp(array[cur], pivotValue) == -1 || compare.cmp(pivotValue, array[cur]) == 1) {
                swap(array, cur++, left++);
            } else if (compare.cmp(array[cur], pivotValue) == 1 || compare.cmp(pivotValue, array[cur]) == -1) {
                swap(array, cur, right--);
            } else {
                cur++;
            }
        }
        return left;
    }
    private void swap(String[] str, int i, int j) {
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
};