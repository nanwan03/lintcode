/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader == null) {
          return -1;
        }
        int left = 0;
        int right = 0;
        while (reader.get(right) != -1 && reader.get(right) < target) {
          left = right;
          right = right * 2 + 1;
        }
        return binarySearch(reader, left, right, target);
    }
    private int binarySearch(ArrayReader reader, int left, int right, int target) {
        while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (reader.get(mid) == -1) {
            right = mid -1;
          } else if (reader.get(mid) == target) {
            right = mid;
          } else if (reader.get(mid) < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        if (reader.get(left) != -1 && reader.get(left) == target) {
          return left;
        } else if (reader.get(right) != -1 && reader.get(right) == target) {
          return right;
        } else {
          return -1;
        }
  }
}