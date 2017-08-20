public class Solution {
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = 0;
        for (int i : pages) {
            max = Math.max(max, i);
            sum += i;
        }
        return helper(pages, k, max, sum);
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
        return isValid(pages, k, left) ? left : right;
    }
    private boolean isValid(int[] pages, int k, int page) {
        int person = 1;
        int sum = 0;
        for (int i : pages) {
            if (sum + i > page) {
                person++;
                sum = 0;
            }
            sum += i;
        }
        return person <= k && sum <= page;
    }
};