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
    public boolean isPalindrome(ListNode head) {
        // STEP 1: Find Middle
        ListNode slow = head; // Middle element
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    

        // STEP 2: Reverse 2nd half
        ListNode newHead = null;
        ListNode primary = slow;
        ListNode temp = slow;

        while (primary != null) {
            primary = primary.next;

            temp.next = newHead;
            newHead = temp;
            temp = primary;
        }

        // STEP 3: Palindrome check
        while (newHead != null) {
            if (newHead.val != head.val) return false;

            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }
}