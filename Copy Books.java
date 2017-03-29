public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int sum = 0;
        int max = 0;
        for (int i : pages) {
            sum += i;
            max = Math.max(max, i);
        }
        if (k >= pages.length) {
            return max;
        }
        int average = sum / k;
        return helper(pages, k, average, sum);
    }
    private int helper(int[] pages, int k, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(pages, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (isValid(pages, k, left)) {
            return left;
        }
        return right;
    }
    private boolean isValid(int[] pages, int k, int page) {
        int sum = 0;
        int people = 1;
        for (int i = 0; i < pages.length && people <= k; ++i) {
            if (sum + pages[i] > page) {
                sum = 0;
                people++;
            }
            sum += pages[i];
        }
        return sum <= page && people <= k;
    }
}