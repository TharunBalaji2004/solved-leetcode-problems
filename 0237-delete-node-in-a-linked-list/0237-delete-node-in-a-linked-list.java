/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // CASE 1: Whether node is last node
        if (node.next == null) node = null;
        // CASE 2: When node is not the last node
        else {
            // Copying the next value 
            int temp = node.next.val;
            node.val = temp;

            node.next = node.next.next;
        }
    }
}