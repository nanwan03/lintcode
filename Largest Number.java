public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // Write your code here
        int n = num.length;
        if (n < 1) return "";
        
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(strs, new Cmp());
        
        String ans = "";
        for (int i = 0; i < n; ++i) {
        	ans = ans.concat(strs[i]);
        }
        
        int i = 0;
        while (i < n && ans.charAt(i) == '0')
            i ++;

        if (i == n) return "0";
        return ans.substring(i);
    }
    class Cmp implements Comparator<String>{
    	@Override
    	public int compare(String a, String b) {
    		String ab = a.concat(b);
    		String ba = b.concat(a);
    		return ba.compareTo(ab);
    	}
    }
}
