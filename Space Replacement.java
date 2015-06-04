public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (length == 0) {
            return length;
        }
        int spaceNum = 0;
        for (char c : string) {
            if (c == ' '){
                spaceNum++;
            } 
        }
        int newLength = length + spaceNum * 2;
        int tail = length - 1;
        for (int i = newLength - 1; i >= 0; --i) {
            if (string[tail] != ' ') {
                string[i] = string[tail--];
            } else {
                string[i] = '0';
                string[i - 1] = '2';
                string[i - 2] = '%';
                i = i - 2;
                tail--;
            }
        }
        return newLength;
    }
}
