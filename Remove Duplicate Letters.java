public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String removeDuplicateLetters(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<Character> deque = new LinkedList<Character>();
        int[] count = new int[256];
        boolean[] isused = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (!isused[c]) {
                while (!deque.isEmpty() && deque.peekFirst() >= c && count[deque.peekFirst()] > 0) {
                    char tail = deque.pollFirst();
                    isused[tail] = false;
                }
                deque.offerFirst(c);
                isused[c] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}