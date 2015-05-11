class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortKColors(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        if (k == 0 || k == 1) {
            return;
        }
        int start = 0;
        for (int i = 1; i < k; i++) {
            start = sortColor(colors, i, start);
        }
    }
    private int sortColor(int[] colors, int target, int start) {
        int left = start;
        int cur = start;
        int right = colors.length - 1;
        while (cur <= right) {
            if (colors[cur] < target) {
                swap(colors, left++, cur++);
            } else if (colors[cur] == target) {
                cur++;
            } else {
                swap(colors, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
