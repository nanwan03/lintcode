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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            carry = add(carry, l1.val, l2.val, tail);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            carry = add(carry, l1.val, 0, tail);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            carry = add(carry, 0, l2.val, tail);
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            carry = add(carry, 0, 0, tail);
            tail = tail.next;
        }
        return dummy.next;
    }
    private int add(int carry, int l1, int l2, ListNode tail) {
        int sum = carry + l1 + l2;
        ListNode node = new ListNode(sum % 10);
        carry = sum / 10;
        tail.next = node;
        return carry;
    }
}
