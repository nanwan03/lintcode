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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightDummy.next;
        rightTail.next = null;
        return leftDummy.next;
    }
}

