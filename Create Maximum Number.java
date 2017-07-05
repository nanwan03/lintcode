public class Solution {
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Write your code here
        if (k == 0) {
            return new int[0];
        }

        int m = nums1.length;
        int n = nums2.length;
        if (m + n < k) {
            return null;
        }
        if (m + n == k) {
            int[] results = merge(nums1, nums2, k);
            return results;
        } else {
            int max = m >= k ? k : m;
            int min = n >= k ? 0 : k - n;
            int[] results = new int[k];
            for(int i = min; i <= max; ++i) {
                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
                results = isGreater(results, 0, temp, 0) ? results : temp;
            }
            return results;
        }
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0) {
            return results;
        }
        int i = 0, j = 0;
        for(int l = 0; l < k; ++l) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                return true;
            }
            if (nums1[i] < nums2[j]) {
                return false;
            }
            i++;
            j++;
        }
        return i != nums1.length;
    }

    private int[] getMax(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] results = new int[k];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[i] <= stack.peek()) {
                stack.push(nums[i]);
            } else if (stack.peek() < nums[i]) {
                while (!stack.isEmpty() && stack.peek() < nums[i] && nums.length - i + stack.size() > k) {
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        while (stack.size() > k) {
            stack.pop();
        }
        for (int i = results.length - 1; i >= 0; --i) {
            results[i] = stack.pop();
        }
        return results;
    }
}