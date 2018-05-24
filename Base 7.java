public class Solution {
    /**
     * @param num: the given number
     * @return: The base 7 string representation
     */
    public String convertToBase7(int num) {
        // Write your code here
        if (num < 0) {
            return '-' + convertToBase7(-num);
        }
        if (num < 7) {
            return String.valueOf(num);
        }
        return convertToBase7(num / 7) + num % 7;
    }
}