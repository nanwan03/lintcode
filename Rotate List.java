/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int n) {
        // write your code here
        int length = getLength(head);
        if (length == 0) {
            return head;
        }
        n = n % length;
        if (n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        for (int i = 0; i < length - n; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        tail.next = dummy.next;
        head.next = null;
        return newHead;
    }
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
