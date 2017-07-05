public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        int length = strs.length;
        int i = 0;
        for (i = 0; i < Math.min(strs[0].length(), strs[length - 1].length()); ++i) {
            if (strs[0].charAt(i) != strs[length - 1].charAt(i)) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}