public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        if (wordDict.remove("") && wordDict.isEmpty()) {
            return new ArrayList<String>();
        }
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }
    private List<String> DFS(String s, Set<String> wordDict, Map<String, List<String>>map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> rst = new ArrayList<String>();  
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (word.equals(s)) {
                    rst.add(word);
                } else {
                    List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                    for (String sub : sublist) {
                        rst.add(word + " " + sub);               
                    }
                }
            }
        }       
        map.put(s, rst);
        return rst;
    }
}