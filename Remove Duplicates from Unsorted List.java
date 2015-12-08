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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<Integer>();
        ListNode dummy = head;
        set.add(head.val);
        while (head != null && head.next != null) {
            if (!set.add(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }  
}