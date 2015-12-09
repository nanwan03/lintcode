public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        if (str == null) {
          return rst;
        }
        char[] chars = str.toCharArray();
        helper(rst, chars, 0);
        return rst;
      }
      private void helper(List<String> rst, char[] chars, int pos) {
        if (pos == chars.length) {
          rst.add(new String(chars));
          return;
        }
        Set<Character> set = new HashSet<Character>();
        for (int i = pos; i < chars.length; i++) {
          char c = chars[i];
          if (set.add(c)) {
            swap(chars, i, pos);
            helper(rst, chars, pos + 1);
            swap(chars, i, pos);
          }
        }
      }
      private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
      }
}