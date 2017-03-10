public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int max = 0;
        int sum = 0;
        for (int page : pages) {
            max = Math.max(max, page);
            sum += page;
        }
        if (k >= pages.length) {
            return max;
        }
        int average = sum / k;
        return binarySearch(pages, k, average, sum);
    }
    private static int binarySearch(int[] pages, int k, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (valid(pages, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (valid(pages, k, left)) {
        	return left;
        } else {
        	return right;
        } 
    }
    private static boolean valid(int[] pages, int k, int page) {
        int sum = 0;
        int people = 0;
        for (int i = 0; i < pages.length && people < k; ++i) {
            if (sum + pages[i] > page) {
                sum = 0;
                ++people;
            }
            sum += pages[i];
        }
        return people < k && sum <= page;
    }
}
