/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.next.val == val) {
                helper(head, val);
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    private void helper(ListNode node, int val) {
        while (node.next != null && node.next.val == val) {
            node.next = node.next.next;
        }
    }
}