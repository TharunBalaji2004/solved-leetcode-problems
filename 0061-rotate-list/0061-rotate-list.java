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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge case
        if (k == 0 || head == null || head.next == null) return head;

        ListNode temp = head;

        // STEP 1: Length Calc
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        } 

        // STEP 2: Form cyclic LL
        temp.next = head;

        // STEP 3: Update k
        k = k % length;
        int count = length - k;

        // STEP 4: Reach before of newHead node
        ListNode newHead = null;
        while (count > 0) {
            temp = temp.next;
            count--;
        }

        // STEP 5: Update the newHead
        newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}