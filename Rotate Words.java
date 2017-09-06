public class Solution {
    /*
     * @param words: A list of words
     * @return: Return how many different rotate words
     */
    public int countRotateWords(List<String> words) {
        // Write your code here
        if (words == null || words.size() == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : words) {
            boolean flag = false;
            for (String key : map.keySet()) {
                if (key.length() == str.length() && (key + key).indexOf(str) != -1) {
                    map.put(key, map.get(key) + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                map.put(str, 1);
            }
        }
        return map.size();
    }
}