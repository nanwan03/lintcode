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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        int length = getLength(head);
        if (length < n) {
            return head;
        }
        int target = length - n + 1;
        for (int index = 1; index < target; ++index) {
            head = head.next;
        }
        return head;
    }
    private int getLength(ListNode head) {
        int rst = 0;
        while (head != null) {
            rst++;
            head = head.next;
        }
        return rst;
    }
}
