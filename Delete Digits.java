public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (k == 0 || A == null || A.length() == 0) {
        	return A;
        }
        Deque<Character> queue = new LinkedList<Character>();
        for (char c : A.toCharArray()) {
        	if (queue.isEmpty() || c >= queue.peekFirst()) {
        		queue.offerFirst(c);
        	} else if (queue.peekFirst() > c){
        		while (!queue.isEmpty() && queue.peekFirst() > c && k > 0) {
        			queue.pollFirst();
        			k--;
        		}
        		queue.offerFirst(c);
        	}
        }
        while (k > 0) {
        	queue.pollFirst();
        	k--;
        }
        while (!queue.isEmpty() && queue.peekLast() == '0') {
        	queue.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
        	sb.append(queue.pollLast());
        }
        return sb.toString();
    }
}
