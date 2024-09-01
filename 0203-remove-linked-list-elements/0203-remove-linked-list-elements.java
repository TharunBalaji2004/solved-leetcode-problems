/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head, prev = null;

        while (temp != null) {
            // CASE 1: When head matches with val
            if (head.val == val) {
                head = head.next;
                temp = head;
            } else if (temp.val == val) { // CASE 2: When middle element matches with val
                prev.next = temp.next;
                temp = temp.next;
            } else { // CASE 3: Move temp pointer
                prev = temp;
                temp = temp.next;
            }
        }
        
        return head;
    }
}