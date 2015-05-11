/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newHead = new RandomListNode(head.label);
            newHead.next = head.next;
            newHead.random = head.random;
            head.next = newHead;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        RandomListNode dummy = newHead;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            if (newHead.next != null) {
                newHead.next = newHead.next.next;
                newHead = newHead.next;
            }
        }
        return dummy;
    }
}
