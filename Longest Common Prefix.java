public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            int j = 0;
            for (j = 0; j < Math.min(prefix.length(), temp.length()); j++) {
                if (prefix.charAt(j) != temp.charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
