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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    private int hashCode (int key, int capacity) {
        return (key + capacity) % capacity;
    }
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        int size = hashTable.length * 2;
        ListNode[] newHash = new ListNode[size];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                ListNode temp = node;
                node = node.next;
                temp.next = null;
                int hash = hashCode(temp.val, size);
                newHash[hash] = insertNode(newHash[hash], temp);
            }
        }
        return newHash;
    }
    private ListNode insertNode(ListNode head, ListNode node) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	while (head.next != null) {
    		head = head.next;
    	}
    	head.next = node;
    	return dummy.next;
    }
};

