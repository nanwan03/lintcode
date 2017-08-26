public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        int[][] a = envelopes;
        if (a == null || a.length == 0) {
            return 0;
        }
        Arrays.sort(a, new Cmp());
        int[] dp = new int[a.length];
        int rst = 0;
        for (int[] i : a) {
            int index = Arrays.binarySearch(dp, 0, rst, i[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = i[1];
            if (index == rst) {
                rst++;
            }
        }
        return rst;
    }
}