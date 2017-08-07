public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here.
    Set<String> set = new HashSet<String>(Arrays.asList(dict));
    if (input == null || input.length() == 0) {
      return set.isEmpty();
    }
    int maxLength = 0;
    for (String word : set) {
        maxLength = Math.max(maxLength, word.length());
    }
    int size = input.length();
    boolean[] dp = new boolean[size + 1];
    dp[0] = true;
    for (int i = 1; i <= size; i++) {
        for (int j = i - 1; j >= 0 && !dp[i] && i - j <= maxLength; j--) {
            if (dp[j] && set.contains(input.substring(j, i))) {
                dp[i] = true;
            }
        }
    }
    return dp[size];
  }
}
