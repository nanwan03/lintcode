public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return "";
        }
        int[] total = new int[200];
        int[] found = new int[200];
        for (int i = 0; i < target.length(); i++) {
            total[target.charAt(i)]++;
        }
        int left = 0;
        int windowSize = 0;
        int start = -1;
        int end = source.length();
        for (int i = 0; i < source.length(); i++) {
            if (total[source.charAt(i)] != 0) {
                found[source.charAt(i)]++;
                if (found[source.charAt(i)] <= total[source.charAt(i)]) {
                    windowSize++;
                }
                if (windowSize == target.length()) {
                    while (left < i) {
                        if (total[source.charAt(left)] == 0 ||
                            --found[source.charAt(left)] >= total[source.charAt(left)]) {
                            left++;
                        } else {
                            break;
                        }
                    }
                    if (i - left < end - start) {
                        start = left;
                        end = i;
                    }
                    left++;
                    windowSize--;
                }
            }
        }
        return start == -1 ? "" : source.substring(start, end + 1);
    }
}
