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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k ==0){
                prev = reverse(prev, head.next);
                head = prev.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    private static ListNode reverse(ListNode head, ListNode tail){
        ListNode rst = head.next;
        ListNode prev = head.next;
        ListNode cur = prev.next;
        while(cur != tail){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next.next = cur;
        head.next = prev;
        return rst;
    }
}