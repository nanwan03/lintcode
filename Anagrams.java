public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    private int getHash(int[] count) {
        int hash = 0;
        for (int i : count) {
            hash = hash * 33 + i;
        }
        return hash;
    }
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(s);
        }
        for (List<String> temp : map.values()) {
            if (temp.size() > 1) {
                rst.addAll(temp);
            }
        }
        return rst;
    }
}
