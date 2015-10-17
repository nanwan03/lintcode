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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        int diff = Math.abs(lengthA - lengthB);
        while (diff > 0) {
            if (lengthA > lengthB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
            diff--;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }  
}
