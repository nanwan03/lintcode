import java.util.*;

class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers == null || numbers.size() == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i < k) {
                queue.offer(numbers.get(i));
            } else {
                if (numbers.get(i) > queue.peek()) {
                    queue.poll();
                    queue.offer(numbers.get(i));
                }
            }
        }
        return queue.peek();
    }
};
