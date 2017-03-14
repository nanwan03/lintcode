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
        int partitionIndex = partition(nuts, left, right, bolts[right], compare);
        partition(bolts, left, right, nuts[partitionIndex], compare);
        quickSort(nuts, bolts, left, partitionIndex - 1, compare);
        quickSort(nuts, bolts, partitionIndex + 1, right, compare);
    }
    private void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private int partition(String[] strings, int left, int right, String partitionValue, NBComparator compare) {
        int cur = left;
        while (cur <= right) {
            if (compare.cmp(strings[cur], partitionValue) == -1 ||
                (compare.cmp(strings[cur], partitionValue) == 2 && compare.cmp(partitionValue, strings[cur]) == 1)) {
                    swap(strings, cur++, left++);
                } else if (compare.cmp(strings[cur], partitionValue) == 1 ||
                            (compare.cmp(strings[cur], partitionValue) == 2 && compare.cmp(partitionValue, strings[cur]) == -1)) {
                                swap(strings, cur, right--);
                    } else {
                        cur++;
                    }
        }
        return left;
    }
};