public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return rst;
        }
        int totalCut = 3;
        String items = new String();
        helper(rst, items, totalCut, s);
        return rst;
    }
    private void helper(List<String> rst, String items, int totalCut, String s) {
        if (totalCut == 0) {
            if (isValid(s)) {
                rst.add(items + s);
            }
            return;
        } else if (totalCut > 0) {
            for (int i = 0; i < Math.min(s.length(), 4); i++) {
                String str = s.substring(0, i + 1);
                if (isValid(str)) {
                    helper(rst, items + str + ".", totalCut - 1, s.substring(i + 1));
                }
            }
        }
    }
    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int temp = Integer.valueOf(s);
        return 1 <= temp && temp <= 255;
    }
}