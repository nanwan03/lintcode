import lintcode.util.ListNode;

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode cur = head;
        ListNode prevM = null;
        ListNode nodeM = null;
        ListNode prev = null;
        for (int i = 0; i <= n; i++) {
            if (i < m) {
                if (i == m - 1) {
                    prevM = cur;
                    nodeM = cur.next;
                }
                cur = cur.next;
            } else {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
        }
        prevM.next = prev;
        nodeM.next = cur;
        return dummy.next;
    }
}
