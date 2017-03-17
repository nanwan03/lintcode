import java.util.*;

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < str.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == str.charAt(j)) {
                            continue;
                        }
                        String temp = replace(str, j, c);
                        if (temp.equals(end)) {
                            return step + 1;
                        }
                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
    private String replace(String str, int index, char c) {
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
