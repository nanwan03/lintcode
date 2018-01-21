public class Solution {
    /**
     * @param arr:  an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] arr) {
        // write your code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int target = sum / 2;
        int tempSum = 0;
        int left = 0;
        int right = arr.length - 1;
        int rst = arr.length - 1;
        while (left <= right) {
            if (tempSum <= target) {
                rst = Math.min(rst, right - left + 1);
                tempSum += arr[left++];
            } else {
                tempSum += arr[right--];
            }
        }
        return rst;
    }
}