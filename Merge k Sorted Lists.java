/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int end = lists.size();
        while (end > 1) {
            int mid = (end + 1) / 2;
            for (int i = 0; i < end / 2; i++) {
                lists.set(i, merge(lists.get(i), lists.get(i + mid)));
            }
            end = mid;
        }
        return lists.get(0);
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next =  left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }
}

