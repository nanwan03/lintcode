public class Solution {
    /**
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // Write your code here
        if (input == null || input.length() == 0) {
            return 0;
        }
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                rst = Math.max(rst, map.get(level) + len);
            } else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return rst;
    }
}