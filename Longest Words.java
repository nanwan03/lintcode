class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> rst = new ArrayList<String>();
        int max = 0;
        for (String str : dictionary) {
            if(str.length() > max) {
                rst.clear();
                rst.add(str);
                max = str.length();
            } else if (str.length() == max) {
                rst.add(str);
            }
        }
        return rst;
    }
};
