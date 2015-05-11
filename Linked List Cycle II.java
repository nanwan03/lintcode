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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        } while (fast != slow) ;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}

