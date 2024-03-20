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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int pos = 0;
        ListNode curr = list1, start = null, end = null;

        while (curr != null) {
            if (pos == a-1) start = curr;
            if (pos == b+1) end = curr;
            pos++;
            curr = curr.next;
        }

        ListNode last = list2;
        while (last.next != null) last = last.next;

        start.next = list2;
        last.next = end;

        return list1;
    }
}