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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev1 = null;
        ListNode cur1 = head;
        ListNode prev2 = null;
        ListNode cur2 = head;
        while (cur1 != null && cur1.val != v1) {
            prev1 = cur1;
            cur1 = cur1.next;
        }
        while(cur2 != null && cur2.val != v2) {
            prev2 = cur2;
            cur2 = cur2.next;
        }
        if (cur1 == null || cur2 == null) {
            return head;
        }
        if (prev1 != null) {
            prev1.next = cur2;
        } else {
            head = cur2;
        }
        if (prev2 != null) {
            prev2.next = cur1;
        } else {
            head = cur1;
        }
        
        ListNode temp = cur1.next;
        cur1.next = cur2.next;
        cur2.next = temp;
        return head;
    }
}