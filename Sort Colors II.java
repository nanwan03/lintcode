class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        sort(colors, 0, colors.length - 1, 1, k);
    }
    private void sort(int[] array, int left, int right, int start, int end) {
        if (start == end) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = start + (end - start) / 2;
        int l = left;
        int r = right;
        while (l <= r) {
            while (l <= r && array[l] <= mid) {
                l++;
            }
            while (l <= r && array[r] > mid) {
                r--;
            }
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        sort(array, left, r, start, mid);
        sort(array, l, right, mid + 1, end);
    }
}