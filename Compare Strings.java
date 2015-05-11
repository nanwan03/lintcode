import java.util.HashMap;
public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return false;
        }
        if (B.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : A.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : B.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            if (map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
