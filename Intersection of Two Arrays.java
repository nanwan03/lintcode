public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null) {
            return null;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        HashSet<Integer> rst = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                rst.add(nums2[i]);
            }
        }
        
        int[] result = new int[rst.size()];
        int index = 0;
        for (Integer num : rst) {
            result[index++] = num;
        }
        
        return result;
    }
}