public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
          return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (A[mid] == target) {
            right = mid;
          } else if (A[mid] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        int leftIndex = -1;
        if (A[left] == target) {
          leftIndex = left;
        } else if (A[right] == target) {
          leftIndex = right;
        } else {
          return 0;
        }
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (A[mid] == target) {
            left = mid;
          } else if (A[mid] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        int rightIndex = -1;
        if (A[right] == target) {
          rightIndex = right;
        } else if (A[left] == target) {
          rightIndex = left;
        } else {
          return 0;
        }
        return rightIndex - leftIndex + 1;
    }
}