public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> degree = new HashMap<Integer, Integer>();
        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            degree.put(num, 0);
        }
        int size = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > size)) {
                return false;
            }
            for (int i = 1; i < seq.length; ++i) {
                if (seq[i] <= 0 || seq[i] > size) {
                    return false;
                }
                if (map.get(seq[i - 1]).add(seq[i])) {
                    degree.put(seq[i], degree.getOrDefault(seq[i], 0) + 1);
                }
            }
        }
        if (count < size) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : degree.keySet()) {
            if (degree.get(key) == 0) {
                queue.offer(key);
            }
        }
        count = 0;
        while (queue.size() == 1) {
            int node = queue.poll();
            for (int next : map.get(node)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            if (node != org[count]) {
                return false;
            }
            count++;
        }
        return count == org.length;
    }
}