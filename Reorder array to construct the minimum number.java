public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    private class Cmp implements Comparator<String> {
        public int compare(String a, String b) {
          return (a + b).compareTo(b + a);
        }
    }
    public String minNumber(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
          return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Cmp());
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
          sb.append(s);
        }
        int i = 0;
        for (i = 0; i < sb.length() && sb.charAt(i) == '0'; ++i){}
        if (i == sb.length()) {
            return "0";
        } else {
            return sb.substring(i);
        }
      }
}