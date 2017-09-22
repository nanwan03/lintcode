public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	if (dict.remove("") && dict.size() == 0) {
    		return 0;
    	}
    	int max = 0;
    	for (String str : dict) {
    		max = Math.max(max, str.length());
    	}
    	int[] dp = new int[s.length() + 1];
    	dp[0] = 1;
    	for (int i = 1; i <= s.length(); ++i) {
    		for (int j = Math.max(0,  i - max); j < i; ++j) {
    			if(dict.contains(s.substring(j, i))) {
    				dp[i]+= dp[j];
    			}
    		}
    	}
    	return dp[s.length()];
    }
}