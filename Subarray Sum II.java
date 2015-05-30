public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    private class Node {
        int value;
        int index;
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.value - b.value;
        }
    }
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int temp = 0;
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(0, 0));
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            list.add(new Node(temp, i + 1));
        }
        Collections.sort(list, new NodeComparator());
        int rst = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            Node n = list.get(i);
            int index = n.index;
            int leftIndex = binarySearchLowerBound(list, i + 1, n.value + start);
            int rightIndex = binarySearchUpperBound(list, i + 1, n.value + end);
            if (leftIndex != -1 && rightIndex != -1) {
                for (int j = leftIndex; j <= rightIndex; ++j) {
                    if (list.get(j).index > index) {
                        rst++;
                    }
                }
                /*
                rst += rightIndex - leftIndex + 1;
                */
            }
        }
        return rst;
    }
    private boolean isValid(int value, int start, int end) {
        return start <= value && value <= end;
    }
    private int binarySearchLowerBound(List<Node> list, int left, int target) {
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).value == target) {
                right = mid;
            } else if (list.get(mid).value < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (list.get(left).value >= target) {
            return left;
        } else if (list.get(right).value >= target) {
            return right;
        } else {
            return -1;
        }
    }
    private int binarySearchUpperBound(List<Node> list, int left, int target) {
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).value == target) {
                left = mid;
            } else if (list.get(mid).value < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (list.get(right).value <= target) {
            return right;
        } else if (list.get(left).value <= target) {
            return left;
        } else {
            return -1;
        }
    }
}
