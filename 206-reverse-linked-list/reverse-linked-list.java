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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        return helper(head, newHead);
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        // Base case - when head reaches end
        if (head == null) return newHead;

        ListNode nextHead = head.next;
        head.next = newHead;

        // Passs the next head as "head", and current head as "newHead"
        return helper(nextHead, head);
    }
}