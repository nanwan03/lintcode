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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return false;
            }
        } while (slow != fast);
        return true;
    }
}

