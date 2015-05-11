public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        int left = 0;
        int right = chars.length - 1;
        int cur = 0;
        while (cur <= right) {
            if ('a' <= chars[cur] && chars[cur] <= 'z') {
                swap(chars, cur++, left++);
            } else {
                cur++;
            }
        }
    }
    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}

