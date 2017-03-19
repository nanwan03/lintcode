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
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }
        int rst = 1;
        ListNode cur = head;
        while (cur.next != null) {
            rst ++;
            cur = cur.next;
        }
        cur.next = head;
        int len = rst - k % rst;
        while (len > 0) {
            cur = cur.next;
            len--;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}